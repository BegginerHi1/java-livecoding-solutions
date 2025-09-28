package ru.nazarovsa.livecodingtraining.datastructures;

import java.util.Iterator;

/**
 * Реализуйте класс очереди. Нельзя использовать готовые структуры данных кроме массива.
 */
public class MyQueue<T> implements Iterable<T> {
    /**
     * Хелпер для имитации out-параметра в методе tryDequeue
     */
    public static class Holder<U> {
        public U value;
    }
    
    /**
     * Количество элементов в очереди
     */
    private int count = 0;
    
    // Здесь должна быть ваша реализация очереди на основе массива
    
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
        throw new UnsupportedOperationException("Конструктор не реализован");
    }

    /**
     * Создает очередь с одним элементом
     */
    public MyQueue(T item) {
        throw new UnsupportedOperationException("Конструктор не реализован");
    }

    /**
     * Создает очередь с элементами из перечисления
     */
    public MyQueue(Iterable<T> items) {
        throw new UnsupportedOperationException("Конструктор не реализован");
    }

    /**
     * Добавляет элемент в очередь
     */
    public void queue(T item) {
        throw new UnsupportedOperationException("Метод не реализован");
    }

    /**
     * Извлекает первый элемент из очереди. Элемент удаляется из очереди.
     * Если очередь пустая выбрасываед IllegalStateException.
     */
    public T dequeue() {
        throw new UnsupportedOperationException("Метод не реализован");
    }

    /**
     * Пытается извлечь первый элемент. При успехе возвращает true и заполняет out параметр элементом. Элемент удаляется из очереди.
     * Если очередь пустая, возвращает false.
     */
    public boolean tryDequeue(Holder<T> item) {
        throw new UnsupportedOperationException("Метод не реализован");
    }

    /**
     * Добавляет элемент в конец очереди
     */
    public void enqueue(T item) {
        throw new UnsupportedOperationException("Метод не реализован");
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("Метод не реализован");
    }
}
