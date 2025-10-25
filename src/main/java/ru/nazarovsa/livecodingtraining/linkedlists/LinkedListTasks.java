package ru.nazarovsa.livecodingtraining.linkedlists;

import ru.nazarovsa.livecodingtraining.linkedlists.infrastructure.Node;

public class LinkedListTasks {

    /**
     * Задача 1.
     * ИСПОЛЬЗОВАНО НА СОЗВОНЕ
     * Реализовать метод, который получает связанный список и целочисленный индекс, а возвращает узел на позиции индекса. Индекс первого узла начинается с 0, второго с 1 и так далее.
     * LinkedListTasks.getNth(1 -> 2 -> 3 -> null, 0).getData() == 1
     * LinkedListTasks.getNth(1 -> 2 -> 3 -> null, 1).getData() == 2
     * Если индекс выходит за границы 0 и длины списка, необходимо выбросить IllegalArgumentException
     */
    public static Node getNth(Node node, int index) {
        if (index < 0) {
            throw new IllegalArgumentException();
        }

        int count = 0;

        while (count < index & node != null) {
            node = node.getNext();
            count++;
        }
        if (index > count) {
            throw new IllegalArgumentException();
        }


        return node;
    }

    /**
     * Задача 2.
     * ИСПОЛЬЗОВАНО НА СОЗВОНЕ
     * Реализовать метод, который вставляет новый узел связного списка в указанный индекс. Индекс первого узла начинается с 0, второго с 1 и так далее.
     * Если индекс выходит за границы 0 и длины списка, необходимо выбросить IllegalArgumentException
     * LinkedListTasks.insertNth(1 -> 2 -> 3 -> null, 0, 7)  => 7 -> 1 -> 2 -> 3 -> null
     * LinkedListTasks.insertNth(1 -> 2 -> 3 -> null, 1, 7)  => 1 -> 7 -> 2 -> 3 -> null
     * LinkedListTasks.insertNth(1 -> 2 -> 3 -> null, 3, 7)  => 1 -> 2 -> 3 -> 7 -> null
     * LinkedListTasks.insertNth(1 -> 2 -> 3 -> null, -2, 7) // throws new IllegalArgumentException
     */
    public static Node insertNth(Node node, int index, int data) {
        if (node == null) {
            return new Node(data);
        }

        if (index < 0 | index > node.size()) {
            throw new IllegalArgumentException();
        }

        if (index == 0) {
            return new Node(data, node);
        }

        Node current = node;
        int count = 0;
        Node temp;

        while (count <= index) {

            if (count + 1 == index & current.getNext() != null) {
                temp = current.getNext();
                current.setNext(new Node(data, temp));
                return node;
            } else if (count + 1 == index & current.getNext() == null) {
                current.setNext(new Node(data));
                return node;
            }

            current = current.getNext();
            count++;
        }

        return node;
    }
}
