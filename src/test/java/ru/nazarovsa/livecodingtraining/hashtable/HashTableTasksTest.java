package ru.nazarovsa.livecodingtraining.hashtable;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HashTableTasksTest {

    @Test
    void isIsomorphic_ShouldReturnCorrectResults() {
        // Тест 1: Изоморфные строки "egg" и "add"
        assertThat(HashTableTasks.isIsomorphic("egg", "add")).isTrue();

        // Тест 2: Неизоморфные строки "foo" и "bar"
        assertThat(HashTableTasks.isIsomorphic("foo", "bar")).isFalse();

        // Тест 3: Изоморфные строки "paper" и "title"
        assertThat(HashTableTasks.isIsomorphic("paper", "title")).isTrue();

        // Тест 4: Неизоморфные строки "ab" и "aa"
        assertThat(HashTableTasks.isIsomorphic("ab", "aa")).isFalse();

        // Тест 5: Разные длины строк
        assertThat(HashTableTasks.isIsomorphic("abc", "ab")).isFalse();

        // Тест 6: Пустые строки
        assertThat(HashTableTasks.isIsomorphic("", "")).isTrue();

        // Тест 7: Однобуквенные одинаковые строки
        assertThat(HashTableTasks.isIsomorphic("a", "a")).isTrue();

        // Тест 8: Однобуквенные разные строки
        assertThat(HashTableTasks.isIsomorphic("a", "b")).isTrue();

        // Тест 9: Обратный случай к "ab" и "aa" - "aa" и "ab"
        assertThat(HashTableTasks.isIsomorphic("aa", "ab")).isFalse();

        // Тест 10: Более сложный случай с повторяющимися символами
        assertThat(HashTableTasks.isIsomorphic("abba", "cddc")).isTrue();

        // Тест 11: Случай где один символ должен соответствовать разным
        assertThat(HashTableTasks.isIsomorphic("abcabc", "xyzxzy")).isFalse();
    }
}


