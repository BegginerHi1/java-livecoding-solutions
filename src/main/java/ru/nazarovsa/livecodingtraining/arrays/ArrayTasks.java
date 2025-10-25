package ru.nazarovsa.livecodingtraining.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Задачи для работы с массивами
 */
public class ArrayTasks {

    /**
     * Задача 25.
     * ИСПОЛЬЗОВАНО НА СОЗВОНЕ
     * Метод принимает массив целых чисел. Необходимо переместить нули в конец массива, сохранив порядок сортировки.
     * [1, 2, 0, 1, 0, 1, 0, 3, 0, 1] -> [1, 2, 1, 1, 3, 1, 0, 0, 0, 0]
     */
    public static int[] moveZeroes(int[] arr) {

        int[] result = new int[arr.length];
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                continue;
            }
            result[count++] = arr[i];

        }
        return result;
    }

    /**
     * Задача 26.
     * ИСПОЛЬЗОВАНО НА СОЗВОНЕ
     * Дан массив, содержащий n различных чисел от 0 до n включительно, но одно число пропущено.
     * Найти это пропущенное число.
     * <p>
     * Ограничения:
     * - n >= 1
     * - Массив содержит только уникальные числа
     * - Числа находятся в диапазоне [0, n]
     * - Длина массива = n (так как одно число пропущено)
     * <p>
     * Примеры:
     * [3,0,1] -> 2 (пропущено число 2 в последовательности 0,1,2,3)
     * [0,1] -> 2 (пропущено число 2 в последовательности 0,1,2)
     * [9,6,4,2,3,5,7,0,1] -> 8 (пропущено число 8 в последовательности 0,1,2,3,4,5,6,7,8,9)
     * [1] -> 0 (пропущено число 0 в последовательности 0,1)
     */
    public static int findMissingNumber(int[] nums) {
        Arrays.sort(nums);

        if (nums[0] != 0) {
            return 0;
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                return nums[i] - 1;
            }
        }

        return nums[nums.length - 1] + 1;
    }

    /**
     * Задача 27.
     * Задача: Монотонность массива
     * Массив называется монотонным, если он либо монотонно возрастающий, либо монотонно убывающий.
     * Массив A монотонно возрастающий если A[i] <= A[i+1] для всех i.
     * Массив A монотонно убывающий если A[i] >= A[i+1] для всех i.
     * Верните true если данный массив монотонный.
     * <p>
     * Примеры:
     * [1,2,2,3] => true (монотонно возрастающий)
     * [6,5,4,4] => true (монотонно убывающий)
     * [1,3,2] => false (не монотонный)
     * [1,2,4,5] => true (монотонно возрастающий)
     * [1,1,1] => true (и возрастающий, и убывающий)
     */
    public static boolean isMonotonic(int[] arr) {
        if (arr.length == 1) {
            return true;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[0] <= arr[arr.length - 1]) {
                if (arr[i] <= arr[i + 1]) {

                } else {
                    return false;
                }
            } else {
                if (arr[i] >= arr[i + 1]) {

                } else {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Задача 29.
     * ИСПОЛЬЗОВАНО НА СОЗВОНЕ
     * Не пустой массив a длины n называется массивом всех возможностей, если он содержит все числа от 0 до a.length - 1 (оба включительно).
     * Реализуйте метод, который принимает массив и возвращает true, если массив является массивом всех возможностей, иначе false.
     * Например, [1,2,0,3] => True, [0,1,2,2,3] => False, [0] => True
     */
    public static boolean isAllPossibilities(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i) {
                return false;
            }
        }
        return true;
    }

    /**
     * Задача 30.
     * ИСПОЛЬЗОВАНО НА СОЗВОНЕ
     * На вход поступает несортированный список уникальных чисел. Необходимо вернуть список в котором за первым максимальным значением будет следовать первое минимальное, за вторым - второе и так далее.
     * Например: [15,11,10,7,12] -> [15,7,12,10,11]
     */
    public static List<Integer> maxMinArray(List<Integer> arr) {
        arr.sort(Comparator.naturalOrder());
        List<Integer> result = new ArrayList<>();
        while (!arr.isEmpty()) {
            if (arr.size() == 1) {
                result.add(arr.getFirst());
                break;
            }
            result.add(arr.getLast());
            result.add(arr.getFirst());
            arr = new ArrayList<>(arr.subList(1, arr.size() - 1));
        }
        return result;

    }
}
