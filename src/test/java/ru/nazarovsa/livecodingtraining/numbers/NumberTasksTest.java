package ru.nazarovsa.livecodingtraining.numbers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class NumberTasksTest {

    @ParameterizedTest
    @CsvSource({
            "16,7",
            "0,0",
            "10,1",
            "942,6",
            "132189,6",
            "493193,2",
            "627969,3",
            "123456789,9"
    })
    void digitalRoot_ReturnsValidResult(long n, int expected) {
        assertThat(NumberTasks.digitalRoot(n)).isEqualTo(expected);
    }
}
