package ru.nazarovsa.livecodingtraining.linkedlists;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LinkedListTasksTest {
    @Test
    void getNth_Returns_Valid_Result() {
        Node list = Node.fromArray(new int[]{0, 1, 2, 3});
        assertThat(LinkedListTasks.getNth(list, 0).getData()).isEqualTo(0);
        assertThat(LinkedListTasks.getNth(list, 1).getData()).isEqualTo(1);
        assertThat(LinkedListTasks.getNth(list, 2).getData()).isEqualTo(2);
    }

    @Test
    void getNth_InvalidIndex_ThrowsIAE() {
        Node list = Node.fromArray(new int[]{0, 1, 2, 3});
        assertThatThrownBy(() -> LinkedListTasks.getNth(list, -1)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> LinkedListTasks.getNth(list, 6)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> LinkedListTasks.getNth(list, 100)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void insertNth_EmptyList_CreatesNewNode() {
        Node node = LinkedListTasks.insertNth(null, 0, 12);
        assertThat(node.getData()).isEqualTo(12);
        assertThat(node.getNext()).isNull();
    }

    @Test
    void insertNth_NonEmptyListIndexZero_InsertsIntoHead() {
        Node list = Node.fromArray(new int[]{0, 1, 2});
        Node node = LinkedListTasks.insertNth(list, 0, -1);
        assertThat(node.toArray()).containsExactly(-1, 0, 1, 2);
    }

    @Test
    void insertNth_NonEmptyListIndexTwo_InsertsIntoIndexTwo() {
        Node list = Node.fromArray(new int[]{0, 1, 3, 4});
        Node node = LinkedListTasks.insertNth(list, 2, 2);
        assertThat(node.toArray()).containsExactly(0, 1, 2, 3, 4);
    }

    @Test
    void insertNth_NonEmptyListTailIndex_InsertsIntoTailOne() {
        Node list = Node.fromArray(new int[]{0, 1});
        Node node = LinkedListTasks.insertNth(list, 2, 2);
        assertThat(node.toArray()).containsExactly(0, 1, 2);
    }

    @Test
    void insertNth_WrongIndex_ThrowsIAE() {
        Node list = Node.fromArray(new int[]{0, 1, 2});
        assertThatThrownBy(() -> LinkedListTasks.insertNth(list, 4, 4)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> LinkedListTasks.insertNth(list, -1, -1)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void iterativeReverse_ThreeElements_ReturnsHeadOfReversed() {
        Node list = Node.fromArray(new int[]{0, 1, 2});
        Node expected = Node.fromArray(new int[]{2, 1, 0});
        Node reversedHead = LinkedListTasks.iterativeReverse(list);
        assertThat(reversedHead.toArray()).containsExactly(expected.toArray());
    }

    @Test
    void recursiveReverse_ThreeElements_ReturnsHeadOfReversed() {
        Node list = Node.fromArray(new int[]{0, 1, 2});
        Node expected = Node.fromArray(new int[]{2, 1, 0});
        Node reversedHead = LinkedListTasks.recursiveReverse(list);
        assertThat(reversedHead.toArray()).containsExactly(expected.toArray());
    }

    @Test
    void middleNode_WithVariousLists_ReturnsExpectedMiddleNode() {
        Node single = new Node(1);
        assertThat(LinkedListTasks.middleNode(single).getData()).isEqualTo(1);

        Node two = new Node(1, new Node(2));
        assertThat(LinkedListTasks.middleNode(two).getData()).isEqualTo(2);

        Node three = new Node(1, new Node(2, new Node(3)));
        assertThat(LinkedListTasks.middleNode(three).getData()).isEqualTo(2);

        Node four = new Node(1, new Node(2, new Node(3, new Node(4))));
        assertThat(LinkedListTasks.middleNode(four).getData()).isEqualTo(3);

        Node five = Node.fromArray(new int[]{1,2,3,4,5});
        assertThat(LinkedListTasks.middleNode(five).getData()).isEqualTo(3);

        Node six = Node.fromArray(new int[]{1,2,3,4,5,6});
        assertThat(LinkedListTasks.middleNode(six).getData()).isEqualTo(4);
    }
}
