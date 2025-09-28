package ru.nazarovsa.livecodingtraining.strings;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringTasksTest {

    @Test
    void unscrambleEggs_ReturnsValidResult() {
        assertThat(StringTasks.unscrambleEggs("ceggodegge heggeregge")).isEqualTo("code here");
        assertThat(StringTasks.unscrambleEggs("FeggUNegg KeggATeggA")).isEqualTo("FUN KATA");
    }

    @Test
    void duplicateCount_ReturnsValidResult() {
        assertThat(StringTasks.duplicateCount("")).isZero();
        assertThat(StringTasks.duplicateCount("abcde")).isZero();
        assertThat(StringTasks.duplicateCount("aabbcde")).isEqualTo(2);
        assertThat(StringTasks.duplicateCount("aabBcde")).isEqualTo(2);
        assertThat(StringTasks.duplicateCount("Indivisibility")).isEqualTo(1);
        assertThat(StringTasks.duplicateCount("Indivisibilities")).isEqualTo(2);
        assertThat(StringTasks.duplicateCount("aA11")).isEqualTo(2);
        assertThat(StringTasks.duplicateCount("ABBA")).isEqualTo(2);
    }

    @Test
    void insertMissingLetters_ReturnsValidResult() {
        assertThat(StringTasks.insertMissingLetters("holly"))
                .isEqualTo("hIJKMNPQRSTUVWXZoPQRSTUVWXZlMNPQRSTUVWXZlyZ");
        assertThat(StringTasks.insertMissingLetters("hello"))
                .isEqualTo("hIJKMNPQRSTUVWXYZeFGIJKMNPQRSTUVWXYZlMNPQRSTUVWXYZloPQRSTUVWXYZ");
        assertThat(StringTasks.insertMissingLetters("ww")).isEqualTo("wXYZw");
        assertThat(StringTasks.insertMissingLetters("wv")).isEqualTo("wXYZvXYZ");
        assertThat(StringTasks.insertMissingLetters("z")).isEqualTo("z");
    }

    @Test
    void groupByCommas_ReturnsValidResult() {
        assertThat(StringTasks.groupByCommas(1)).isEqualTo("1");
        assertThat(StringTasks.groupByCommas(12)).isEqualTo("12");
        assertThat(StringTasks.groupByCommas(123)).isEqualTo("123");
        assertThat(StringTasks.groupByCommas(1234)).isEqualTo("1,234");
        assertThat(StringTasks.groupByCommas(12345)).isEqualTo("12,345");
        assertThat(StringTasks.groupByCommas(123456)).isEqualTo("123,456");
        assertThat(StringTasks.groupByCommas(1234567)).isEqualTo("1,234,567");
        assertThat(StringTasks.groupByCommas(12345678)).isEqualTo("12,345,678");
        assertThat(StringTasks.groupByCommas(123456789)).isEqualTo("123,456,789");
        assertThat(StringTasks.groupByCommas(1234567890)).isEqualTo("1,234,567,890");
    }

    @Test
    void validParentheses_Returns_True() {
        assertThat(StringTasks.validParentheses("")).isTrue();
        assertThat(StringTasks.validParentheses("()")).isTrue();
        assertThat(StringTasks.validParentheses("((()))")).isTrue();
        assertThat(StringTasks.validParentheses("()()()")).isTrue();
        assertThat(StringTasks.validParentheses("(()())()")).isTrue();
        assertThat(StringTasks.validParentheses("()(())((()))(())()"))
            .isTrue();
    }

    @Test
    void validParentheses_Returns_False() {
        assertThat(StringTasks.validParentheses(")(")).isFalse();
        assertThat(StringTasks.validParentheses("()()(")).isFalse();
        assertThat(StringTasks.validParentheses("((())")).isFalse();
        assertThat(StringTasks.validParentheses("())(()")).isFalse();
        assertThat(StringTasks.validParentheses(")")).isFalse();
    }

    @Test
    void uInt32ToIP_ReturnsValidIP() {
        assertThat(StringTasks.uInt32ToIP(2154959208L)).isEqualTo("128.114.17.104");
        assertThat(StringTasks.uInt32ToIP(0L)).isEqualTo("0.0.0.0");
        assertThat(StringTasks.uInt32ToIP(2149583361L)).isEqualTo("128.32.10.1");
    }

    @Test
    void maxUniqueStringLength_ReturnsCorrectLength() {
        assertThat(StringTasks.maxUniqueStringLength("")).isEqualTo(0);
        assertThat(StringTasks.maxUniqueStringLength("аааобагдааа")).isEqualTo(5);
        assertThat(StringTasks.maxUniqueStringLength("абвадга")).isEqualTo(5);
        assertThat(StringTasks.maxUniqueStringLength("абвгдеж")).isEqualTo(7);
        assertThat(StringTasks.maxUniqueStringLength("ааааааа")).isEqualTo(1);
    }

    @Test
    void rleCompress_VariousInputScenarios_ReturnsCorrectCompression() {
        assertThat(StringTasks.rleCompress("AAAAABBBBCCDDDOEEEF")).isEqualTo("A5B4C2D3O1E3F1");
        assertThat(StringTasks.rleCompress("")).isEqualTo("");
        assertThat(StringTasks.rleCompress("A")).isEqualTo("A1");
        assertThat(StringTasks.rleCompress("AAAAAAA")).isEqualTo("A7");
        assertThat(StringTasks.rleCompress("ABCDEF")).isEqualTo("A1B1C1D1E1F1");
        assertThat(StringTasks.rleCompress("AABBCCDD")).isEqualTo("A2B2C2D2");
        assertThat(StringTasks.rleCompress("ABABABAB")).isEqualTo("A1B1A1B1A1B1A1B1");
        assertThat(StringTasks.rleCompress("AAABBBAAACCCAAA")).isEqualTo("A3B3A3C3A3");
        assertThat(StringTasks.rleCompress("AAAaaBBBbbbCCC")).isEqualTo("A3a2B3b3C3");
        assertThat(StringTasks.rleCompress("ZYX")).isEqualTo("Z1Y1X1");
        assertThat(StringTasks.rleCompress("AAAAAAAAAABAAAAA")).isEqualTo("A10B1A5");
    }

    @Test
    void toUnderScore_ReturnsValidSnakeCaseString() {
        assertThat(StringTasks.toUnderScore("TestController")).isEqualTo("test_controller");
        assertThat(StringTasks.toUnderScore("ThisIsBeautifulDay")).isEqualTo("this_is_beautiful_day");
        assertThat(StringTasks.toUnderScore("Am7Days")).isEqualTo("am7_days");
        assertThat(StringTasks.toUnderScore("My3CodeIs4TimesBetter")).isEqualTo("my3_code_is4_times_better");
        assertThat(StringTasks.toUnderScore("ArbitrarilySendingDifferentTypesToFunctionsMakesKatasCool"))
            .isEqualTo("arbitrarily_sending_different_types_to_functions_makes_katas_cool");
    }

    @Test
    void longestCommonPrefix_ReturnsValidResult() {
        assertThat(StringTasks.longestCommonPrefix(new String[]{"flower","flow","flight"}))
            .isEqualTo("fl");
        assertThat(StringTasks.longestCommonPrefix(new String[]{"interstellar","internet","internal"}))
            .isEqualTo("inter");
        assertThat(StringTasks.longestCommonPrefix(new String[]{"testing","tester","test"}))
            .isEqualTo("test");
        assertThat(StringTasks.longestCommonPrefix(new String[]{"dog","racecar","car"}))
            .isEqualTo("");
        assertThat(StringTasks.longestCommonPrefix(new String[]{"abc","def","ghi"}))
            .isEqualTo("");
        assertThat(StringTasks.longestCommonPrefix(new String[]{"a","b"}))
            .isEqualTo("");
        assertThat(StringTasks.longestCommonPrefix(new String[]{"same","same","same"}))
            .isEqualTo("same");
        assertThat(StringTasks.longestCommonPrefix(new String[]{"hello","hello"}))
            .isEqualTo("hello");
        assertThat(StringTasks.longestCommonPrefix(new String[]{"single"}))
            .isEqualTo("single");
        assertThat(StringTasks.longestCommonPrefix(new String[]{""}))
            .isEqualTo("");
        assertThat(StringTasks.longestCommonPrefix(new String[]{}))
            .isEqualTo("");
        assertThat(StringTasks.longestCommonPrefix(new String[]{"prefix","","pref"}))
            .isEqualTo("");
        assertThat(StringTasks.longestCommonPrefix(new String[]{"","test","example"}))
            .isEqualTo("");
        assertThat(StringTasks.longestCommonPrefix(new String[]{"a","aa","aaa"}))
            .isEqualTo("a");
        assertThat(StringTasks.longestCommonPrefix(new String[]{"prefix","pre","preparation"}))
            .isEqualTo("pre");
    }

    @Test
    void reverseWordsInString_ReturnsValidResult() {
        assertThat(StringTasks.reverseWordsInString("hello world")).isEqualTo("olleh dlrow");
        assertThat(StringTasks.reverseWordsInString("The quick brown fox")).isEqualTo("ehT kciuq nworb xof");
        assertThat(StringTasks.reverseWordsInString("hello")).isEqualTo("olleh");
        assertThat(StringTasks.reverseWordsInString("a")).isEqualTo("a");
        assertThat(StringTasks.reverseWordsInString("")).isEqualTo("");
        assertThat(StringTasks.reverseWordsInString("  test  ")).isEqualTo("  tset  ");
        assertThat(StringTasks.reverseWordsInString(" hello world ")).isEqualTo(" olleh dlrow ");
        assertThat(StringTasks.reverseWordsInString("hello   world")).isEqualTo("olleh   dlrow");
        assertThat(StringTasks.reverseWordsInString("a  b  c")).isEqualTo("a  b  c");
        assertThat(StringTasks.reverseWordsInString("abc   def")).isEqualTo("cba   fed");
        assertThat(StringTasks.reverseWordsInString("   ")).isEqualTo("   ");
        assertThat(StringTasks.reverseWordsInString(" ")).isEqualTo(" ");
        assertThat(StringTasks.reverseWordsInString("123 456")).isEqualTo("321 654");
        assertThat(StringTasks.reverseWordsInString("#@! ^%$")).isEqualTo("!@# $%^");
        assertThat(StringTasks.reverseWordsInString("abc123 def456")).isEqualTo("321cba 654fed");
        assertThat(StringTasks.reverseWordsInString("CbA fEd")).isEqualTo("AbC dEf");
        assertThat(StringTasks.reverseWordsInString("HELLO world")).isEqualTo("OLLEH dlrow");
        assertThat(StringTasks.reverseWordsInString("testing")).isEqualTo("gnitset");
        assertThat(StringTasks.reverseWordsInString("application")).isEqualTo("noitacilppa");
        assertThat(StringTasks.reverseWordsInString("a b c d")).isEqualTo("a b c d");
    }
}
