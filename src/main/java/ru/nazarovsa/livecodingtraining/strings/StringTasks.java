package ru.nazarovsa.livecodingtraining.strings;

import java.util.HashSet;
import java.util.Set;

/**
 * Задачи для работы со строками
 */
public class StringTasks {

    /**
     * Задача 7.
     * ИСПОЛЬЗОВАНО НА СОЗВОНЕ
     * Входная строка содержит латинские символы в верхнем и(или) нижнем регистре.
     * Метод возвращает количество символов, встречающихся более одного раза. Сравнение должно быть не чувствительно к регистру.
     * "abcde" -> 0 # нет символов встречающихся более одного раза
     * "aabbcde" -> 2 # 'a' и 'b'
     * "aabBcde" -> 2 # 'a' и 'b' встречается дважды (`b` и `B`)
     * "indivisibility" -> 1 # 'i' встречается 6 раз
     * "Indivisibilities" -> 2 # 'i' встречается 7 раз и 's' встречается дважды
     * "aA11" -> 2 # 'a' и '1'
     * "ABBA" -> 2 # 'A' и 'B' оба встречаются дважды
     */
    public static int duplicateCount(String str) {
        String strLower = str.toLowerCase();
        String[] arrStr = strLower.split("");

        Set<String> check = new HashSet<>();
        int count = 0;

        for (int i = 0; i < arrStr.length; i++) {
            for (int j = i + 1; j < arrStr.length; j++) {
                if (arrStr[j].equals(arrStr[i]) & !check.contains(arrStr[j])) {
                    check.add(arrStr[j]);
                    count++;
                    break;
                }
            }
        }
        return count;

    }

    /**
     * Задача 8.
     * ИСПОЛЬЗОВАНО НА СОЗВОНЕ
     * Входная строка содержит латинские символы. После каждой согласной следует слово egg, необходимо вернуть строку без egg.
     */
    public static String unscrambleEggs(String word) {
        String[] wordWithoutEgg;
        StringBuilder result = new StringBuilder();

        if (word.contains("egg")) {
            wordWithoutEgg = word.split("egg");
            for (String s : wordWithoutEgg) {
                result.append(s);
            }
            return result.toString();
        }
        return word;
    }
}
