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
        assertThat(StringTasks.maxUniqueStringLength("")).isZero();
        assertThat(StringTasks.maxUniqueStringLength("аааобагдааа")).isEqualTo(5);
        assertThat(StringTasks.maxUniqueStringLength("абвадга")).isEqualTo(5);
        assertThat(StringTasks.maxUniqueStringLength("абвгдеж")).isEqualTo(7);
        assertThat(StringTasks.maxUniqueStringLength("ааааааа")).isEqualTo(1);
    }

    @Test
    void rleCompress_VariousInputScenarios_ReturnsCorrectCompression() {
        assertThat(StringTasks.rleCompress("AAAAABBBBCCDDDOEEEF")).isEqualTo("A5B4C2D3O1E3F1");
        assertThat(StringTasks.rleCompress("")).isEmpty();
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
            .isEmpty();
        assertThat(StringTasks.longestCommonPrefix(new String[]{"abc","def","ghi"}))
            .isEmpty();
        assertThat(StringTasks.longestCommonPrefix(new String[]{"a","b"}))
            .isEmpty();
        assertThat(StringTasks.longestCommonPrefix(new String[]{"same","same","same"}))
            .isEqualTo("same");
        assertThat(StringTasks.longestCommonPrefix(new String[]{"hello","hello"}))
            .isEqualTo("hello");
        assertThat(StringTasks.longestCommonPrefix(new String[]{"single"}))
            .isEqualTo("single");
        assertThat(StringTasks.longestCommonPrefix(new String[]{""}))
            .isEmpty();
        assertThat(StringTasks.longestCommonPrefix(new String[]{}))
            .isEmpty();
        assertThat(StringTasks.longestCommonPrefix(new String[]{"prefix","","pref"}))
            .isEmpty();
        assertThat(StringTasks.longestCommonPrefix(new String[]{"","test","example"}))
            .isEmpty();
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
        assertThat(StringTasks.reverseWordsInString("")).isEmpty();
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

    @Test
    void areAnagrams_ReturnsTrue_WhenStringsAreAnagrams() {
        assertThat(StringTasks.areAnagrams("listen", "silent")).isTrue();
        assertThat(StringTasks.areAnagrams("elbow", "below")).isTrue();
        assertThat(StringTasks.areAnagrams("study", "dusty")).isTrue();
        assertThat(StringTasks.areAnagrams("a gentleman", "elegant man")).isTrue();
        assertThat(StringTasks.areAnagrams("", "")).isTrue();
    }

    @Test
    void areAnagrams_ReturnsFalse_WhenStringsAreNotAnagrams() {
        assertThat(StringTasks.areAnagrams("hello", "bello")).isFalse();
        assertThat(StringTasks.areAnagrams("Hello", "hello")).isFalse();
        assertThat(StringTasks.areAnagrams("conversation", "voices rant on")).isFalse();
        assertThat(StringTasks.areAnagrams("abc", "def")).isFalse();
        assertThat(StringTasks.areAnagrams("aab", "abb")).isFalse();
        assertThat(StringTasks.areAnagrams("Astronomer", "Moon starer")).isFalse();
    }

    @Test
    void canFormTarget_ReturnsTrue_WhenTargetCanBeFormed() {
        assertThat(StringTasks.canFormTarget("programming", "gram")).isTrue();
        assertThat(StringTasks.canFormTarget("abc", "cab")).isTrue();
        assertThat(StringTasks.canFormTarget("a", "")).isTrue();
        assertThat(StringTasks.canFormTarget("aab", "ab")).isTrue();
    }

    @Test
    void canFormTarget_ReturnsFalse_WhenTargetCannotBeFormed() {
        assertThat(StringTasks.canFormTarget("hello", "world")).isFalse();
        assertThat(StringTasks.canFormTarget("abc", "abcc")).isFalse();
        assertThat(StringTasks.canFormTarget("", "a")).isFalse();
        assertThat(StringTasks.canFormTarget("Programming", "pro")).isFalse();
    }

    @Test
    void firstUniqueChar_ReturnsCorrectIndex_WhenUniqueCharExists() {
        assertThat(StringTasks.firstUniqueChar("leetcode")).isZero();
        assertThat(StringTasks.firstUniqueChar("loveleetcode")).isEqualTo(2);
        assertThat(StringTasks.firstUniqueChar("abcdef")).isZero();
        assertThat(StringTasks.firstUniqueChar("a")).isZero();
    }

    @Test
    void firstUniqueChar_ReturnsMinusOne_WhenNoUniqueCharExists() {
        assertThat(StringTasks.firstUniqueChar("aabbcc")).isEqualTo(-1);
        assertThat(StringTasks.firstUniqueChar("abccba")).isEqualTo(-1);
        assertThat(StringTasks.firstUniqueChar("")).isEqualTo(-1);
    }

    @Test
    void groupCharactersByPosition_ReturnsCorrectMap() {
        var result1 = StringTasks.groupCharactersByPosition("hello");
        assertThat(result1.get('h')).containsExactly(0);
        assertThat(result1.get('e')).containsExactly(1);
        assertThat(result1.get('l')).containsExactly(2, 3);
        assertThat(result1.get('o')).containsExactly(4);

        var result2 = StringTasks.groupCharactersByPosition("abcabc");
        assertThat(result2.get('a')).containsExactly(0, 3);
        assertThat(result2.get('b')).containsExactly(1, 4);
        assertThat(result2.get('c')).containsExactly(2, 5);

        var result3 = StringTasks.groupCharactersByPosition("");
        assertThat(result3.size()).isZero();

        var result4 = StringTasks.groupCharactersByPosition("aaa");
        assertThat(result4.get('a')).containsExactly(0, 1, 2);
    }

    @Test
    void formatPhoneNumber_ReturnsFormattedNumber_WhenValidInput() {
        assertThat(StringTasks.formatPhoneNumber("abc123def456gh7890")).isEqualTo("(123) 456-7890");
        assertThat(StringTasks.formatPhoneNumber("123-456-7890")).isEqualTo("(123) 456-7890");
        assertThat(StringTasks.formatPhoneNumber("(555) 123-4567")).isEqualTo("(555) 123-4567");
        assertThat(StringTasks.formatPhoneNumber("1234567890")).isEqualTo("(123) 456-7890");
    }

    @Test
    void formatPhoneNumber_ReturnsInvalidMessage_WhenInvalidInput() {
        assertThat(StringTasks.formatPhoneNumber("12345")).isEqualTo("Invalid phone number");
        assertThat(StringTasks.formatPhoneNumber("12345678901")).isEqualTo("Invalid phone number");
        assertThat(StringTasks.formatPhoneNumber("no digits here!")).isEqualTo("Invalid phone number");
        assertThat(StringTasks.formatPhoneNumber("")).isEqualTo("Invalid phone number");
    }

    @Test
    void decodeRle_ReturnsDecodedString() {
        assertThat(StringTasks.decodeRle("a3b2c")).isEqualTo("aaabbc");
        assertThat(StringTasks.decodeRle("abcd")).isEqualTo("abcd");
        assertThat(StringTasks.decodeRle("x10y2z")).isEqualTo("xxxxxxxxxxyyz");
        assertThat(StringTasks.decodeRle("")).isEmpty();
        assertThat(StringTasks.decodeRle("a1")).isEqualTo("a");
        assertThat(StringTasks.decodeRle("a10b1c5")).isEqualTo("aaaaaaaaaabccccc");
    }

    @Test
    void decodeRoman_ReturnsCorrectNumber() {
        assertThat(StringTasks.decodeRoman("XIV")).isEqualTo(14);
        assertThat(StringTasks.decodeRoman("MCMXC")).isEqualTo(1990);
        assertThat(StringTasks.decodeRoman("CDXLIV")).isEqualTo(444);
        assertThat(StringTasks.decodeRoman("I")).isEqualTo(1);
        assertThat(StringTasks.decodeRoman("V")).isEqualTo(5);
        assertThat(StringTasks.decodeRoman("X")).isEqualTo(10);
        assertThat(StringTasks.decodeRoman("L")).isEqualTo(50);
        assertThat(StringTasks.decodeRoman("C")).isEqualTo(100);
        assertThat(StringTasks.decodeRoman("D")).isEqualTo(500);
        assertThat(StringTasks.decodeRoman("M")).isEqualTo(1000);
        assertThat(StringTasks.decodeRoman("IV")).isEqualTo(4);
        assertThat(StringTasks.decodeRoman("IX")).isEqualTo(9);
        assertThat(StringTasks.decodeRoman("XL")).isEqualTo(40);
        assertThat(StringTasks.decodeRoman("XC")).isEqualTo(90);
        assertThat(StringTasks.decodeRoman("CD")).isEqualTo(400);
        assertThat(StringTasks.decodeRoman("CM")).isEqualTo(900);
        assertThat(StringTasks.decodeRoman("MMXXIII")).isEqualTo(2023);
    }
}
