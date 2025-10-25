package ru.nazarovsa.livecodingtraining.datastructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Реализуйте класс очереди. Нельзя использовать готовые структуры данных кроме массива.
 */
public class MyQueue<T> implements Iterable<T> {
    /**
     * Количество элементов в очереди
     */
    private int count = 0;

    // Здесь должна быть ваша реализация очереди на основе массива
    private T[] elements;

    /**
     * Количество элементов в очереди
     */
    public int getCount() {
        return count;
    }

    /**
     * Создает пустую очередь
     */
    public MyQueue() {
        elements = (T[]) new Object[]{};
    }

    /**
     * Создает очередь с одним элементом
     */
    public MyQueue(T item) {
        elements = (T[]) new Object[]{item};
        count = 1;
    }

    /**
     * Создает очередь с элементами из перечисления
     */
    public MyQueue(Iterable<T> items) {
        for (T i : items) {
            count++;
        }
        elements = (T[]) new Object[count];

        count = 0;
        for (T i : items) {
            elements[count] = i;
            count++;
        }
    }

    /**
     * Извлекает первый элемент из очереди. Элемент удаляется из очереди.
     * Если очередь пустая выбрасывает IllegalStateException.
     */
    public T dequeue() {
        if (count != 0) {
            T element = elements[0];
            System.arraycopy(elements, 1, elements, 0, elements.length - 1);
            count--;
            return element;
        }
        throw new IllegalStateException();
    }

    /**
     * Извлекает и удаляет первый элемент из очереди.
     * Возвращает null, если очередь пустая (аналог стандартного Queue.poll()).
     */
    public T poll() {
        try {
            return dequeue();
        } catch (IllegalStateException e) {
            return null;
        }
    }

    /**
     * Возвращает первый элемент без удаления.
     * Возвращает null, если очередь пустая (аналог стандартного Queue.peek()).
     */
    public T peek() {
        return count != 0 ? elements[0] : null;
    }

    /**
     * Добавляет элемент в конец очереди
     */
    public void enqueue(T item) {
        T[] newData = (T[]) new Object[elements.length + 1];
        System.arraycopy(elements, 0, newData, 0, elements.length);
        newData[count] = item;
        elements = newData;
        count++;

    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int cursor = 0;

            @Override
            public boolean hasNext() {
                return cursor < count;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return elements[cursor++];
            }
        };
    }
}
