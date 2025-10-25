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
}
