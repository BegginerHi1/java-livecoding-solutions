package ru.nazarovsa.livecodingtraining.hashtable;

import java.util.HashMap;
import java.util.Map;

public class HashTableTasks {

    /**
     * Задача 41.
     * ИСПОЛЬЗОВАНО НА СОЗВОНЕ
     * Проверяет, являются ли две строки изоморфными.
     * <p>
     * Две строки изоморфны, если символы в одной строке можно заменить на символы
     * в другой строке, сохраняя порядок символов. Каждый символ в первой строке
     * должен соответствовать ровно одному символу во второй строке и наоборот.
     * <p>
     * Примеры:
     * Вход: s = "egg", t = "add" → Выход: true
     * Объяснение: e→a, g→d. Символ 'e' всегда соответствует 'a', 'g' всегда соответствует 'd'
     * <p>
     * Вход: s = "foo", t = "bar" → Выход: false
     * Объяснение: 'o' должен соответствовать и 'a' и 'r', что невозможно
     * <p>
     * Вход: s = "paper", t = "title" → Выход: true
     * Объяснение: p→t, a→i, p→t, e→l, r→e
     * <p>
     * Вход: s = "ab", t = "aa" → Выход: false
     * Объяснение: 'a' и 'b' не могут оба соответствовать 'a'
     */
    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        String[] sArr = s.split("");
        String[] tArr = t.split("");

        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < sArr.length; i++) {

            if (map.containsKey(sArr[i])) {
                if (!map.get(sArr[i]).equals(tArr[i])) {
                    return false;
                }
            } else if (!map.containsKey(sArr[i]) & map.containsValue(tArr[i])) {
                return false;
            }

            map.put(sArr[i], tArr[i]);


        }
        return true;
    }
}
