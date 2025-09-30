package ru.nazarovsa.livecodingtraining.yieldreturn;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class YieldReturnTasksTest {

    @Test
    void AnalyzeLogStream_WithSimpleScenario_ReturnsTwoAlerts() {
        List<String> logLines = Arrays.asList(
            "2024-01-01 10:00:01 INFO User login",
            "2024-01-01 10:00:02 ERROR Database timeout",
            "2024-01-01 10:00:03 ERROR Connection failed",
            "2024-01-01 10:00:04 ERROR Invalid token",
            "2024-01-01 10:00:05 INFO Request processed",
            "2024-01-01 10:00:06 ERROR Access denied",
            "2024-01-01 10:00:07 INFO Data saved",
            "2024-01-01 10:00:08 INFO User logout"
        );

        List<String> results = YieldReturnTasks.analyzeLogStream(logLines.stream(), 3).collect(Collectors.toList());

        assertThat(results).hasSize(3);
        assertThat(results.get(0)).isEqualTo("ALERT in last 5 entries position 4");
        assertThat(results.get(1)).isEqualTo("ALERT in last 5 entries position 5");
        assertThat(results.get(2)).isEqualTo("ALERT in last 5 entries position 6");
    }

    @Test
    void AnalyzeLogStream_WithNoErrors_ReturnsNoAlerts() {
        List<String> logLines = Arrays.asList(
            "2024-01-01 10:00:01 INFO User login",
            "2024-01-01 10:00:02 INFO Request processed",
            "2024-01-01 10:00:03 INFO Data saved",
            "2024-01-01 10:00:04 INFO User logout",
            "2024-01-01 10:00:05 INFO Session ended"
        );

        List<String> results = YieldReturnTasks.analyzeLogStream(logLines.stream(), 3).collect(Collectors.toList());
        assertThat(results).isEmpty();
    }

    @Test
    void AnalyzeLogStream_WithLessThan5Entries_ReturnsNoAlerts() {
        List<String> logLines = Arrays.asList(
            "2024-01-01 10:00:01 ERROR Database timeout",
            "2024-01-01 10:00:02 ERROR Connection failed",
            "2024-01-01 10:00:03 ERROR Invalid token"
        );

        List<String> results = YieldReturnTasks.analyzeLogStream(logLines.stream(), 3).collect(Collectors.toList());
        assertThat(results).isEmpty();
    }

    @Test
    void AnalyzeLogStream_WithDefaultThreshold_ReturnsCorrectAlerts() {
        List<String> logLines = Arrays.asList(
            "2024-01-01 10:00:01 INFO User login",
            "2024-01-01 10:00:02 ERROR Database timeout",
            "2024-01-01 10:00:03 ERROR Connection failed",
            "2024-01-01 10:00:04 INFO Request processed",
            "2024-01-01 10:00:05 ERROR Invalid token",
            "2024-01-01 10:00:06 ERROR Access denied",
            "2024-01-01 10:00:07 ERROR Server overload",
            "2024-01-01 10:00:08 INFO User logout"
        );

        List<String> results = YieldReturnTasks.analyzeLogStream(logLines.stream(), 3).collect(Collectors.toList());
        assertThat(results).hasSize(4);
        assertThat(results.get(0)).isEqualTo("ALERT in last 5 entries position 4");
        assertThat(results.get(1)).isEqualTo("ALERT in last 5 entries position 5");
        assertThat(results.get(2)).isEqualTo("ALERT in last 5 entries position 6");
        assertThat(results.get(3)).isEqualTo("ALERT in last 5 entries position 7");
    }

    @Test
    void AnalyzeLogStream_WithCustomThreshold_ReturnsCorrectAlerts() {
        List<String> logLines = Arrays.asList(
            "2024-01-01 10:00:01 INFO User login",
            "2024-01-01 10:00:02 ERROR Database timeout",
            "2024-01-01 10:00:03 ERROR Connection failed",
            "2024-01-01 10:00:04 INFO Request processed",
            "2024-01-01 10:00:05 INFO Data saved",
            "2024-01-01 10:00:06 INFO User logout"
        );

        List<String> results = YieldReturnTasks.analyzeLogStream(logLines.stream(), 2).collect(Collectors.toList());
        assertThat(results.get(0)).isEqualTo("ALERT in last 5 entries position 4");
        assertThat(results.get(1)).isEqualTo("ALERT in last 5 entries position 5");
    }

    @Test
    void AnalyzeLogStream_WithExactlyThresholdErrors_ReturnsAlert() {
        List<String> logLines = Arrays.asList(
            "2024-01-01 10:00:01 ERROR Database timeout",
            "2024-01-01 10:00:02 ERROR Connection failed",
            "2024-01-01 10:00:03 ERROR Invalid token",
            "2024-01-01 10:00:04 INFO Request processed",
            "2024-01-01 10:00:05 INFO Data saved"
        );

        List<String> results = YieldReturnTasks.analyzeLogStream(logLines.stream(), 3).collect(Collectors.toList());
        assertThat(results).hasSize(1);
        assertThat(results.getFirst()).isEqualTo("ALERT in last 5 entries position 4");
    }

    @Test
    void AnalyzeLogStream_WithEmptyInput_ReturnsNoAlerts() {
        List<String> logLines = Arrays.asList();
        List<String> results = YieldReturnTasks.analyzeLogStream(logLines.stream(), 3).collect(Collectors.toList());
        assertThat(results).isEmpty();
    }

    @Test
    void AnalyzeLogStream_IsLazyEvaluated_DoesNotProcessAllItemsImmediately() {
        var processedCount = new AtomicInteger(0);
        Stream<String> logLines = Stream.iterate(0, i -> i + 1).limit(20)
            .map(i -> {
                processedCount.incrementAndGet();
                return i < 10
                        ? String.format("2024-01-01 10:00:%02d ERROR Error %d", i, i)
                        : String.format("2024-01-01 10:00:%02d INFO Info %d", i, i);
            });

        var first = YieldReturnTasks.analyzeLogStream(logLines, 3).findFirst().orElse(null);
        assertThat(processedCount.get()).isLessThan(20);
    }

    @Test
    void AnalyzeLogStream_WithSlidingWindow_UpdatesCorrectly() {
        List<String> logLines = Arrays.asList(
            "2024-01-01 10:00:01 ERROR Error 1",
            "2024-01-01 10:00:02 ERROR Error 2",
            "2024-01-01 10:00:03 ERROR Error 3",
            "2024-01-01 10:00:04 ERROR Error 4",
            "2024-01-01 10:00:05 INFO Info 1",
            "2024-01-01 10:00:06 INFO Info 2",
            "2024-01-01 10:00:07 INFO Info 3",
            "2024-01-01 10:00:08 INFO Info 4",
            "2024-01-01 10:00:09 INFO Info 5"
        );

        List<String> results = YieldReturnTasks.analyzeLogStream(logLines.stream(), 3).collect(Collectors.toList());
        assertThat(results).hasSize(2);
        assertThat(results.get(0)).isEqualTo("ALERT in last 5 entries position 4");
        assertThat(results.get(1)).isEqualTo("ALERT in last 5 entries position 5");
    }
}

