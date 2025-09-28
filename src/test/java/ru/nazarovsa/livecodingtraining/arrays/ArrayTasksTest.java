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
    void biggest_ReturnsValidString() {
        assertThat(ArrayTasks.biggest(new int[]{1, 2, 3})).isEqualTo("321");
        assertThat(ArrayTasks.biggest(new int[]{3, 30, 34, 5, 9})).isEqualTo("9534330");
        assertThat(ArrayTasks.biggest(new int[]{100, 321, 987, 15, 5})).isEqualTo("987532115100");
    }

    @Test
    void minimumToPrime_ReturnsValidAddition() {
        assertThat(ArrayTasks.minimumToPrime(new int[]{3, 1, 2})).isEqualTo(1);
        assertThat(ArrayTasks.minimumToPrime(new int[]{5, 2})).isZero();
        assertThat(ArrayTasks.minimumToPrime(new int[]{1, 1, 1})).isZero();
        assertThat(ArrayTasks.minimumToPrime(new int[]{2, 12, 8, 4, 6})).isEqualTo(5);
        assertThat(ArrayTasks.minimumToPrime(new int[]{50, 39, 49, 6, 17, 28})).isEqualTo(2);
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
    void twoSum_ReturnsValidResult() {
        assertThat(ArrayTasks.twoSum(new int[]{2, 7, 11, 15}, 9))
                .containsExactly(0, 1);
        assertThat(ArrayTasks.twoSum(new int[]{2, 3, 4}, 6))
                .containsExactly(0, 2);
        assertThat(ArrayTasks.twoSum(new int[]{-1, 0}, -1))
                .containsExactly(0, 1);
    }

    @Test
    void findEvenIndex_ReturnsValidResult() {
        assertThat(ArrayTasks.findEvenIndex(new int[]{1, 2, 3, 4, 3, 2, 1})).isEqualTo(3);
        assertThat(ArrayTasks.findEvenIndex(new int[]{1, 100, 50, -51, 1, 1})).isEqualTo(1);
        assertThat(ArrayTasks.findEvenIndex(new int[]{1, 2, 3, 4, 5, 6})).isEqualTo(-1);
        assertThat(ArrayTasks.findEvenIndex(new int[]{20, 10, 30, 10, 10, 15, 35})).isEqualTo(3);
        assertThat(ArrayTasks.findEvenIndex(new int[]{})).isEqualTo(-1);
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
    void mergeIntervals_ReturnsValidResult() {
        // Базовые тесты
        var result1 = ArrayTasks.mergeIntervals(new int[][]{
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        });
        assertThat(result1).isDeepEqualTo(new int[][]{
                {1, 6},
                {8, 10},
                {15, 18}
        });

        // Перекрытие на границе
        var result2 = ArrayTasks.mergeIntervals(new int[][]{
                {1, 4},
                {4, 5}
        });
        assertThat(result2).isDeepEqualTo(new int[][]{
                {1, 5}
        });

        // Без перекрытий
        var result3 = ArrayTasks.mergeIntervals(new int[][]{
                {1, 4},
                {5, 6}
        });
        assertThat(result3).isDeepEqualTo(new int[][]{
                {1, 4},
                {5, 6}
        });

        // Полное включение одного интервала в другой
        var result4 = ArrayTasks.mergeIntervals(new int[][]{
                {1, 4},
                {2, 3}
        });
        assertThat(result4).isDeepEqualTo(new int[][]{
                {1, 4}
        });

        // Несортированные интервалы на входе
        var result5 = ArrayTasks.mergeIntervals(new int[][]{
                {2, 6},
                {1, 3},
                {15, 18},
                {8, 10}
        });
        assertThat(result5).isDeepEqualTo(new int[][]{
                {1, 6},
                {8, 10},
                {15, 18}
        });

        // Один интервал
        var result6 = ArrayTasks.mergeIntervals(new int[][]{
                {1, 5}
        });
        assertThat(result6).isDeepEqualTo(new int[][]{
                {1, 5}
        });

        // Пустой массив
        var result7 = ArrayTasks.mergeIntervals(new int[][]{});
        assertThat(result7).isDeepEqualTo(new int[][]{});

        // Множественные перекрытия
        var result8 = ArrayTasks.mergeIntervals(new int[][]{
                {1, 10},
                {2, 5},
                {3, 7},
                {6, 8},
                {9, 12}
        });
        assertThat(result8).isDeepEqualTo(new int[][]{
                {1, 12}
        });
    }

    @Test
    void compressByMajority_ReturnsValidResult() {
        // Основные примеры
        assertThat(ArrayTasks.compressByMajority(new int[]{1, 1, 1, 2, 3, 3, 4, 4, 4, 4}))
                .containsExactly(1, 2, 3, 3, 4);
        assertThat(ArrayTasks.compressByMajority(new int[]{5, 5, 2, 2, 2, 2, 2, 1}))
                .containsExactly(5, 5, 2, 1);
        assertThat(ArrayTasks.compressByMajority(new int[]{1, 2, 3}))
                .containsExactly(1, 2, 3);

        // Граничные случаи
        assertThat(ArrayTasks.compressByMajority(new int[]{}))
                .isEmpty(); // пустой массив
        assertThat(ArrayTasks.compressByMajority(null))
                .isEmpty(); // null массив
        assertThat(ArrayTasks.compressByMajority(new int[]{5}))
                .containsExactly(5); // один элемент

        // Случаи с точно 3 элементами
        assertThat(ArrayTasks.compressByMajority(new int[]{7, 7, 7}))
                .containsExactly(7); // точно 3 элемента
        assertThat(ArrayTasks.compressByMajority(new int[]{1, 1, 1, 1, 1, 1}))
                .containsExactly(1); // много одинаковых

        // Смешанные случаи
        assertThat(ArrayTasks.compressByMajority(new int[]{1, 1, 2, 2, 2, 3, 3}))
                .containsExactly(1, 1, 2, 3, 3); // только средняя группа сжимается
        assertThat(ArrayTasks.compressByMajority(new int[]{1, 1, 1, 2, 2, 2, 3, 3, 3}))
                .containsExactly(1, 2, 3); // все группы сжимаются
        assertThat(ArrayTasks.compressByMajority(new int[]{4, 4, 1, 1, 1, 1, 9, 9, 9}))
                .containsExactly(4, 4, 1, 9); // разные размеры групп

        // Случаи с отрицательными числами
        assertThat(ArrayTasks.compressByMajority(new int[]{-1, -1, -1, 0, 0, 5, 5, 5, 5}))
                .containsExactly(-1, 0, 0, 5);

        // Чередующиеся паттерны
        assertThat(ArrayTasks.compressByMajority(new int[]{1, 2, 1, 2, 1}))
                .containsExactly(1, 2, 1, 2, 1); // нет групп из 3+
        assertThat(ArrayTasks.compressByMajority(new int[]{1, 1, 1, 2, 2, 2, 1, 1, 1}))
                .containsExactly(1, 2, 1); // группы одинаковых чисел разделены
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

    @Test
    void groupSameElements_ReturnsValidResult() {
        // Основные случаи
        assertThat(ArrayTasks.groupSameElements(new int[]{1, 2, 1, 3, 2, 1}))
                .containsExactly(1, 1, 1, 2, 2, 3);
        assertThat(ArrayTasks.groupSameElements(new int[]{4, 4, 2, 1, 2}))
                .containsExactly(4, 4, 2, 2, 1);
        assertThat(ArrayTasks.groupSameElements(new int[]{3, 1, 3, 2, 1, 2, 3, 2}))
                .containsExactly(3, 3, 3, 1, 1, 2, 2, 2);

        // Все элементы уникальны
        assertThat(ArrayTasks.groupSameElements(new int[]{1, 2, 3}))
                .containsExactly(1, 2, 3);
        assertThat(ArrayTasks.groupSameElements(new int[]{5, 4, 3, 2, 1}))
                .containsExactly(5, 4, 3, 2, 1);

        // Все элементы одинаковы
        assertThat(ArrayTasks.groupSameElements(new int[]{5, 5, 5}))
                .containsExactly(5, 5, 5);
        assertThat(ArrayTasks.groupSameElements(new int[]{7, 7, 7, 7, 7}))
                .containsExactly(7, 7, 7, 7, 7);

        // Граничные случаи
        assertThat(ArrayTasks.groupSameElements(new int[]{42}))
                .containsExactly(42); // один элемент
        assertThat(ArrayTasks.groupSameElements(new int[]{}))
                .isEmpty(); // пустой массив
        assertThat(ArrayTasks.groupSameElements(null))
                .isEmpty(); // null

        // Отрицательные числа
        assertThat(ArrayTasks.groupSameElements(new int[]{-1, 0, 1, -1, 0, 1}))
                .containsExactly(-1, -1, 0, 0, 1, 1);
        assertThat(ArrayTasks.groupSameElements(new int[]{-5, -3, -5, -3, -3}))
                .containsExactly(-5, -5, -3, -3, -3);

        // Сложные случаи
        assertThat(ArrayTasks.groupSameElements(new int[]{1, 2, 3, 1, 4, 3, 1, 4, 1, 4}))
                .containsExactly(1, 1, 1, 1, 2, 3, 3, 4, 4, 4);
        assertThat(ArrayTasks.groupSameElements(new int[]{0, 5, 10, 0, 10, 5, 0, 10, 10}))
                .containsExactly(0, 0, 0, 5, 5, 10, 10, 10, 10);
    }

    @Test
    void intersection_ReturnsValidResult() {
        // Пример 1: [1,2,2,1], [2,2] -> [2] (число 2 присутствует в обоих массивах)
        assertThat(ArrayTasks.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2}))
                .containsExactly(2);

        // Пример 2: [4,9,5], [9,4,9,8,4] -> [4,9] или [9,4] (числа 4 и 9 присутствуют в обоих)
        assertThat(ArrayTasks.intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}))
                .hasSize(2)
                .contains(4, 9);

        // Пример 3: [1,2,3], [4,5,6] -> [] (нет общих элементов)
        assertThat(ArrayTasks.intersection(new int[]{1, 2, 3}, new int[]{4, 5, 6}))
                .isEmpty();

        // Пример 4: [1,1,1], [1,1] -> [1] (число 1 присутствует в обоих, но возвращается только один раз)
        assertThat(ArrayTasks.intersection(new int[]{1, 1, 1}, new int[]{1, 1}))
                .containsExactly(1);

        // Пример 5: [], [1,2,3] -> [] (один из массивов пустой)
        assertThat(ArrayTasks.intersection(new int[]{}, new int[]{1, 2, 3}))
                .isEmpty();

        // Пример 6: [7], [7] -> [7] (одинаковые массивы из одного элемента)
        assertThat(ArrayTasks.intersection(new int[]{7}, new int[]{7}))
                .containsExactly(7);

        // Дополнительные тест-кейсы:

        // Пустой первый массив
        assertThat(ArrayTasks.intersection(new int[]{1, 2, 3}, new int[]{}))
                .isEmpty();

        // Оба массива пустые
        assertThat(ArrayTasks.intersection(new int[]{}, new int[]{}))
                .isEmpty();

        // Большой пример с множественными дубликатами
        assertThat(ArrayTasks.intersection(new int[]{1, 2, 2, 3, 3, 3}, new int[]{3, 3, 4, 2, 2, 5}))
                .hasSize(2)
                .contains(2, 3);

        // Отрицательные числа
        assertThat(ArrayTasks.intersection(new int[]{-1, -2, 0, 1}, new int[]{-2, 0, 2}))
                .hasSize(2)
                .contains(-2, 0);

        // Одинаковые массивы
        assertThat(ArrayTasks.intersection(new int[]{1, 2, 3}, new int[]{1, 2, 3}))
                .hasSize(3)
                .contains(1, 2, 3);

        // Один элемент общий в начале
        assertThat(ArrayTasks.intersection(new int[]{1, 2, 3}, new int[]{1, 4, 5}))
                .containsExactly(1);

        // Один элемент общий в конце
        assertThat(ArrayTasks.intersection(new int[]{1, 2, 3}, new int[]{4, 5, 3}))
                .containsExactly(3);

        // Нет общих элементов - отрицательные и положительные
        assertThat(ArrayTasks.intersection(new int[]{-3, -2, -1}, new int[]{1, 2, 3}))
                .isEmpty();

        // Массив с нулями
        assertThat(ArrayTasks.intersection(new int[]{0, 1, 0, 2}, new int[]{0, 3, 0}))
                .containsExactly(0);
    }
}
