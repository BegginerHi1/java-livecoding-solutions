package ru.nazarovsa.livecodingtraining.linkedlists;

public class LinkedListTasks {

    /**
     * ИСПОЛЬЗОВАНО НА СОЗВОНЕ
     * Реализовать метод, который получает связанный список и целочисленный индекс, а возвращает узел на позиции индекса. Индекс первого узла начинается с 0, второго с 1 и так далее.
     * LinkedListTasks.getNth(1 -> 2 -> 3 -> null, 0).getData() == 1
     * LinkedListTasks.getNth(1 -> 2 -> 3 -> null, 1).getData() == 2
     * Если индекс выходит за границы 0 и длины списка, необходимо выбросить IllegalArgumentException
     */
    public static Node getNth(Node node, int index) {
        throw new UnsupportedOperationException("Метод не реализован");
    }

    /**
     * ИСПОЛЬЗОВАНО НА СОЗВОНЕ
     * Реализовать итеративный метод переворачивания связанного списка. Метод должен вернуть голову нового списка.
     */
    public static Node iterativeReverse(Node node) {
        throw new UnsupportedOperationException("Метод не реализован");
    }

    /**
     * ИСПОЛЬЗОВАНО НА СОЗВОНЕ
     * Реализовать рекурсивный метод переворачивания связанного списка. Метод должен вернуть голову нового списка.
     */
    public static Node recursiveReverse(Node node) {
        throw new UnsupportedOperationException("Метод не реализован");
    }

    /**
     * ИСПОЛЬЗОВАНО НА СОЗВОНЕ
     * Дан односвязный список.
     * Необходимо найти средний узел списка.
     * Если в списке четное количество узлов, вернуть второй из двух средних узлов.
     * Примеры:
     * 
     * Список: [1,2,3,4,5] → вернуть узел со значением 3
     * Список: [1,2,3,4,5,6] → вернуть узел со значением 4
     */
    public static Node middleNode(Node head) {
        throw new UnsupportedOperationException("Метод не реализован");
    }

    /**
     * ИСПОЛЬЗОВАНО НА СОЗВОНЕ
     * Реализовать метод, который вставляет новый узел связного списка в указанный индекс. Индекс первого узла начинается с 0, второго с 1 и так далее.
     * Если индекс выходит за границы 0 и длины списка, необходимо выбросить IllegalArgumentException
     * LinkedListTasks.insertNth(1 -> 2 -> 3 -> null, 0, 7)  => 7 -> 1 -> 2 -> 3 -> null
     * LinkedListTasks.insertNth(1 -> 2 -> 3 -> null, 1, 7)  => 1 -> 7 -> 2 -> 3 -> null
     * LinkedListTasks.insertNth(1 -> 2 -> 3 -> null, 3, 7)  => 1 -> 2 -> 3 -> 7 -> null
     * LinkedListTasks.insertNth(1 -> 2 -> 3 -> null, -2, 7) // throws new IllegalArgumentException
     */
    public static Node insertNth(Node node, int index, int data) {
        throw new UnsupportedOperationException("Метод не реализован");
    }
}
