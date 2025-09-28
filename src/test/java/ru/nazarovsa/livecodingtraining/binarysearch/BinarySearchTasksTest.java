package ru.nazarovsa.livecodingtraining.binarysearch;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class BinarySearchTasksTest {

    @ParameterizedTest
    @CsvSource({
            "1,true",
            "4,true",
            "9,true",
            "16,true",
            "25,true",
            "36,true",
            "49,true",
            "64,true",
            "81,true",
            "100,true",
            "121,true",
            "144,true",
            "169,true",
            "196,true",
            "225,true",
            "10000,true",
            "40000,true",
            "1000000,true",
            "2,false",
            "3,false",
            "5,false",
            "6,false",
            "7,false",
            "8,false",
            "10,false",
            "15,false",
            "24,false",
            "35,false",
            "48,false",
            "63,false",
            "80,false",
            "99,false",
            "122,false",
            "143,false",
            "168,false",
            "195,false",
            "224,false",
            "9999,false",
            "39999,false",
            "999999,false",
            "0,false",
            "-1,false",
            "-4,false",
            "-16,false",
            "2147395600,true",
            "2147483646,false"
    })
    void isPerfectSquare_WithVariousInputs_ReturnsExpectedResult(int num, boolean expected) {
        assertThat(BinarySearchTasks.isPerfectSquare(num)).isEqualTo(expected);
    }
}
