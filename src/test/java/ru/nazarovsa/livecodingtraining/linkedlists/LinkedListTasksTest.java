package ru.nazarovsa.livecodingtraining.linkedlists;

import org.junit.jupiter.api.Test;
import ru.nazarovsa.livecodingtraining.linkedlists.infrastructure.Node;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LinkedListTasksTest {
    @Test
    void getNth_Returns_Valid_Result() {
        var list = Node.fromArray(new int[]{0, 1, 2, 3});
        assertThat(LinkedListTasks.getNth(list, 0).getData()).isZero();
        assertThat(LinkedListTasks.getNth(list, 1).getData()).isEqualTo(1);
        assertThat(LinkedListTasks.getNth(list, 2).getData()).isEqualTo(2);
    }

    @Test
    void getNth_InvalidIndex_ThrowsIAE() {
        var list = Node.fromArray(new int[]{0, 1, 2, 3});
        assertThatThrownBy(() -> LinkedListTasks.getNth(list, -1)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> LinkedListTasks.getNth(list, 6)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> LinkedListTasks.getNth(list, 100)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void insertNth_EmptyList_CreatesNewNode() {
        var node = LinkedListTasks.insertNth(null, 0, 12);
        assertThat(node.getData()).isEqualTo(12);
        assertThat(node.getNext()).isNull();
    }

    @Test
    void insertNth_NonEmptyListIndexZero_InsertsIntoHead() {
        var list = Node.fromArray(new int[]{0, 1, 2});
        var node = LinkedListTasks.insertNth(list, 0, -1);
        assertThat(node.toArray()).containsExactly(-1, 0, 1, 2);
    }

    @Test
    void insertNth_NonEmptyListIndexTwo_InsertsIntoIndexTwo() {
        var list = Node.fromArray(new int[]{0, 1, 3, 4});
        var node = LinkedListTasks.insertNth(list, 2, 2);
        assertThat(node.toArray()).containsExactly(0, 1, 2, 3, 4);
    }

    @Test
    void insertNth_NonEmptyListTailIndex_InsertsIntoTailOne() {
        var list = Node.fromArray(new int[]{0, 1});
        var node = LinkedListTasks.insertNth(list, 2, 2);
        assertThat(node.toArray()).containsExactly(0, 1, 2);
    }

    @Test
    void insertNth_WrongIndex_ThrowsIAE() {
        var list = Node.fromArray(new int[]{0, 1, 2});
        assertThatThrownBy(() -> LinkedListTasks.insertNth(list, 4, 4)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> LinkedListTasks.insertNth(list, -1, -1)).isInstanceOf(IllegalArgumentException.class);
    }
}
