package ru.nazarovsa.livecodingtraining.linkedlists.infrastructure;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Узел односвязного списка
 */
@Data
public class Node {
    private final int data;
    private Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    /**
     * Создает связный список из массива значений
     */
    public static Node fromArray(int[] values) {
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException("Массив не может быть пустым");
        }

        Node head = new Node(values[0]);
        Node current = head;

        for (int i = 1; i < values.length; i++) {
            current.next = new Node(values[i]);
            current = current.next;
        }

        return head;
    }

    /**
     * Преобразует связный список в массив
     */
    public int[] toArray() {
        List<Integer> values = new ArrayList<>();
        Node current = this;
        while (current != null) {
            values.add(current.data);
            current = current.next;
        }
        return values.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * Преобразует связный список в список
     */
    public List<Integer> toList() {
        List<Integer> values = new ArrayList<>();
        Node current = this;
        while (current != null) {
            values.add(current.data);
            current = current.next;
        }
        return values;
    }

    /**
     * Возвращает размер списка
     */
    public int size() {
        int count = 0;
        Node current = this;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Node node = (Node) obj;
        return data == node.data && Objects.equals(next, node.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, next);
    }

    @Override
    public String toString() {
        return toList().stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" -> "));
    }
}
