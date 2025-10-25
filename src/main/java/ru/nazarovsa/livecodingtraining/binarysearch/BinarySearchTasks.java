package ru.nazarovsa.livecodingtraining.binarysearch;

import java.math.BigInteger;


public class BinarySearchTasks {

    /**
     * Задача 38.
     * ИСПОЛЬЗОВАНО НА СОЗВОНЕ
     * Условие:
     * Дано положительное целое число n. Определите,
     * является ли это число совершенным квадратом (то есть существует ли такое целое число k, что k² = n).
     * Входные данные:
     * <p>
     * Одно положительное целое число n (1 ≤ n ≤ 10⁹)
     * <p>
     * Выходные данные:
     * <p>
     * true, если число является совершенным квадратом
     * false, если число не является совершенным квадратом
     * <p>
     * Функциональные ограничения: временная сложность log(n)
     */

    public static boolean isPerfectSquare(int n) {
        if (n == 0) {
            return false;
        } else if ((n * n == n) | ((n / 2) * (n / 2) == n)) {
            return true;
        }

        BigInteger bigN = BigInteger.valueOf(n);
        BigInteger start = BigInteger.ZERO;
        BigInteger end = bigN.divide(BigInteger.TWO);
        BigInteger mid = end.subtract(start).divide(BigInteger.TWO);

        for (; start.compareTo(end) < 0; ) {
            if ((start.add(BigInteger.ONE).compareTo(end) == 0)
                    & (start.multiply(start).compareTo(bigN) != 0)
                    & (end.multiply(end).compareTo(bigN) != 0)) {
                return false;
            }
            if (mid.multiply(mid).compareTo(bigN) == 0) {
                return true;
            } else if (mid.multiply(mid).compareTo(bigN) > 0) {
                end = mid;
                mid = end.subtract(start).divide(BigInteger.TWO);
            } else {
                start = mid;
                mid = start.add(end).divide(BigInteger.TWO);
            }
        }
        return false;
    }
}
