package ru.nazarovsa.livecodingtraining.arrays;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class ArrayTasksTest {

    @Test
    void isAllPossibilities_ReturnsValidAnswer() {
        assertThat(ArrayTasks.isAllPossibilities(new int[]{1, 2, 0, 3})).isTrue();
        assertThat(ArrayTasks.isAllPossibilities(new int[]{0})).isTrue();
        assertThat(ArrayTasks.isAllPossibilities(new int[]{0, 1, 2, 2, 3})).isFalse();
        assertThat(ArrayTasks.isAllPossibilities(new int[]{1, 2, 2, 3})).isFalse();
    }

    @Test
    void maxMinArray_ReturnsValidArray() {
        assertThat(ArrayTasks.maxMinArray(Arrays.asList(15, 11, 10, 7, 12)))
                .containsExactly(15, 7, 12, 10, 11);
        assertThat(ArrayTasks.maxMinArray(Arrays.asList(91, 75, 86, 14, 82)))
                .containsExactly(91, 14, 86, 75, 82);
        assertThat(ArrayTasks.maxMinArray(Arrays.asList(84, 79, 76, 61, 78)))
                .containsExactly(84, 61, 79, 76, 78);
        assertThat(ArrayTasks.maxMinArray(Arrays.asList(52, 77, 72, 44, 74, 76, 40)))
                .containsExactly(77, 40, 76, 44, 74, 52, 72);
        assertThat(ArrayTasks.maxMinArray(Arrays.asList(1, 6, 9, 4, 3, 7, 8, 2)))
                .containsExactly(9, 1, 8, 2, 7, 3, 6, 4);
        assertThat(ArrayTasks.maxMinArray(Arrays.asList(78, 79, 52, 87, 16, 74, 31, 63, 80)))
                .containsExactly(87, 16, 80, 31, 79, 52, 78, 63, 74);
    }

    @Test
    void moveZeroes_ReturnsValidResult() {
        assertThat(ArrayTasks.moveZeroes(new int[]{1, 2, 0, 1, 0, 1, 0, 3, 0, 1}))
                .containsExactly(1, 2, 1, 1, 3, 1, 0, 0, 0, 0);
        assertThat(ArrayTasks.moveZeroes(new int[]{1, 2, 3, 0}))
                .containsExactly(1, 2, 3, 0);
        assertThat(ArrayTasks.moveZeroes(new int[]{0, 1, 2, 3}))
                .containsExactly(1, 2, 3, 0);
    }

    @Test
    void findMissingNumber_ReturnsValidResult() {
        // Базовые случаи
        assertThat(ArrayTasks.findMissingNumber(new int[]{3, 0, 1})).isEqualTo(2);
        assertThat(ArrayTasks.findMissingNumber(new int[]{0, 1})).isEqualTo(2);
        assertThat(ArrayTasks.findMissingNumber(new int[]{1})).isZero();

        // Пропущено число в середине
        assertThat(ArrayTasks.findMissingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1})).isEqualTo(8);
        assertThat(ArrayTasks.findMissingNumber(new int[]{0, 1, 2, 4, 5})).isEqualTo(3);

        // Пропущено первое число
        assertThat(ArrayTasks.findMissingNumber(new int[]{3, 1, 2})).isZero();

        // Пропущено последнее число
        assertThat(ArrayTasks.findMissingNumber(new int[]{0, 1, 2, 3})).isEqualTo(4);
        assertThat(ArrayTasks.findMissingNumber(new int[]{2, 0, 1})).isEqualTo(3);

        // Большой массив
        assertThat(ArrayTasks.findMissingNumber(
                IntStream.range(0, 100).filter(x -> x != 50).toArray())).isEqualTo(50);

        // Минимальный случай
        assertThat(ArrayTasks.findMissingNumber(new int[]{0})).isEqualTo(1);

        // Массив с одним элементом - пропущен 0
        assertThat(ArrayTasks.findMissingNumber(new int[]{1})).isZero();

        // Отсортированный массив с пропуском в конце
        assertThat(ArrayTasks.findMissingNumber(new int[]{0, 1, 2, 3, 4})).isEqualTo(5);

        // Обратно отсортированный массив
        assertThat(ArrayTasks.findMissingNumber(new int[]{4, 3, 1, 0})).isEqualTo(2);
    }

    @Test
    void isMonotonic_ReturnsValidResult() {
        // Монотонно возрастающие
        assertThat(ArrayTasks.isMonotonic(new int[]{1, 2, 2, 3})).isTrue();
        assertThat(ArrayTasks.isMonotonic(new int[]{1, 1, 1})).isTrue();
        assertThat(ArrayTasks.isMonotonic(new int[]{1, 2, 4, 5})).isTrue();
        assertThat(ArrayTasks.isMonotonic(new int[]{5})).isTrue();
        assertThat(ArrayTasks.isMonotonic(new int[]{1, 2})).isTrue();

        // Монотонно убывающие
        assertThat(ArrayTasks.isMonotonic(new int[]{6, 5, 4, 4})).isTrue();
        assertThat(ArrayTasks.isMonotonic(new int[]{10, 5, 2, 1, 0})).isTrue();
        assertThat(ArrayTasks.isMonotonic(new int[]{5, 4})).isTrue();

        // Не монотонные
        assertThat(ArrayTasks.isMonotonic(new int[]{1, 3, 2})).isFalse();
        assertThat(ArrayTasks.isMonotonic(new int[]{1, 2, 4, 5, 3, 3, 7})).isFalse();
        assertThat(ArrayTasks.isMonotonic(new int[]{5, 3, 5, 4})).isFalse();
        assertThat(ArrayTasks.isMonotonic(new int[]{2, 2, 3, 1, 4})).isFalse();

        // Граничные случаи
        assertThat(ArrayTasks.isMonotonic(new int[]{})).isTrue(); // пустой массив
        assertThat(ArrayTasks.isMonotonic(new int[]{100, 100, 100, 100})).isTrue(); // все элементы равны
    }
}
