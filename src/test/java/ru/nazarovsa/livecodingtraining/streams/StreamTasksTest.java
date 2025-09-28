package ru.nazarovsa.livecodingtraining.streams;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StreamTasksTest {

    @Test
    void myReverse_ReturnsValidResult() {
        List<Integer> source = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> result = StreamTasks.myReverse(source);
        assertThat(result).containsExactly(5, 4, 3, 2, 1);
    }

    @Test
    void mySkip_ReturnsValidResult() {
        List<Integer> source = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> result = StreamTasks.mySkip(source, 2);
        assertThat(result).containsExactly(3, 4, 5);
        
        List<Integer> emptyResult = StreamTasks.mySkip(source, 10);
        assertThat(emptyResult).isEmpty();
    }

    @Test
    void myTake_ReturnsValidResult() {
        List<Integer> source = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> result = StreamTasks.myTake(source, 3);
        assertThat(result).containsExactly(1, 2, 3);
        
        List<Integer> allResult = StreamTasks.myTake(source, 10);
        assertThat(allResult).containsExactly(1, 2, 3, 4, 5);
    }

    @Test
    void mySkipLast_ReturnsValidResult() {
        List<Integer> source = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> result = StreamTasks.mySkipLast(source, 2);
        assertThat(result).containsExactly(1, 2, 3);
        
        List<Integer> emptyResult = StreamTasks.mySkipLast(source, 10);
        assertThat(emptyResult).isEmpty();
    }

    @Test
    void myTakeLast_ReturnsValidResult() {
        List<Integer> source = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> result = StreamTasks.myTakeLast(source, 3);
        assertThat(result).containsExactly(3, 4, 5);
        
        List<Integer> allResult = StreamTasks.myTakeLast(source, 10);
        assertThat(allResult).containsExactly(1, 2, 3, 4, 5);
    }

    @Test
    void myReverse_EmptyList_ReturnsEmpty() {
        List<String> empty = Arrays.asList();
        List<String> result = StreamTasks.myReverse(empty);
        assertThat(result).isEmpty();
    }

    @Test
    void myTake_ZeroCount_ReturnsEmpty() {
        List<Integer> source = Arrays.asList(1, 2, 3);
        List<Integer> result = StreamTasks.myTake(source, 0);
        assertThat(result).isEmpty();
    }
}

