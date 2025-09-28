package ru.nazarovsa.livecodingtraining.datastructures;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MyQueueTest {

    @Test
    void constructor_Parameterless_CreatesQueue() {
        MyQueue<Integer> queue = new MyQueue<>();

        assertThat(queue).isNotNull();
        assertThat(queue.getCount()).isZero();
        assertThat(queue).isEmpty();
    }

    @Test
    void constructor_SingleItem_CreatesQueue() {
        int item = 1;
        MyQueue<Integer> queue = new MyQueue<>(item);

        assertThat(queue).isNotNull();
        assertThat(queue.getCount()).isEqualTo(1);
        assertThat(queue).hasSize(1);

        // Проверяем, что первый элемент - это наш item
        Iterator<Integer> iterator = queue.iterator();
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isEqualTo(item);
    }

    @Test
    void constructor_MultipleItems_CreatesQueue() {
        var items = Arrays.asList(1, 2, 3);
        MyQueue<Integer> queue = new MyQueue<>(items);

        assertThat(queue).isNotNull();
        assertThat(queue.getCount()).isEqualTo(items.size());
        assertThat(queue).containsExactlyElementsOf(items);
    }

    @Test
    void dequeue_EmptyQueue_ThrowsIllegalStateException() {
        MyQueue<Integer> queue = new MyQueue<>();

        assertThatThrownBy(queue::dequeue)
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void dequeue_OneElement_ReturnsElementAndRemovesFromQueue() {
        int item = 0;
        MyQueue<Integer> queue = new MyQueue<>(item);

        Integer result = queue.dequeue();

        assertThat(result).isEqualTo(item);
        assertThat(queue).isEmpty();
        assertThat(queue.getCount()).isZero();
    }

    @Test
    void dequeue_TwoElements_ReturnsFirstElementAndSecondBecomesFirst() {
        var items = Arrays.asList(1, 2);
        MyQueue<Integer> queue = new MyQueue<>(items);

        Integer result = queue.dequeue();

        assertThat(result).isEqualTo(1); // первый элемент
        assertThat(queue.getCount()).isEqualTo(1);
        
        // Проверяем, что второй элемент стал первым
        Iterator<Integer> iterator = queue.iterator();
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isEqualTo(2);
    }

    @Test
    void tryDequeue_EmptyQueue_ReturnsFalseAndItemIsDefault() {
        MyQueue<Integer> queue = new MyQueue<>();
        MyQueue.Holder<Integer> holder = new MyQueue.Holder<>();

        boolean result = queue.tryDequeue(holder);

        assertThat(result).isFalse();
        assertThat(holder.value).isNull(); // default для Integer это null
    }

    @Test
    void tryDequeue_TwoElements_ReturnsTrueAndItemIsDefinedAndRemovedFromQueue() {
        var items = Arrays.asList(1, 2);
        MyQueue<Integer> queue = new MyQueue<>(items);
        MyQueue.Holder<Integer> holder = new MyQueue.Holder<>();

        boolean result = queue.tryDequeue(holder);

        assertThat(result).isTrue();
        assertThat(holder.value).isEqualTo(1); // первый элемент
        assertThat(queue.getCount()).isEqualTo(1);
        
        // Проверяем, что второй элемент стал первым
        Iterator<Integer> iterator = queue.iterator();
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isEqualTo(2);
    }

    @Test
    void enqueue_EmptyQueue_AddsElement() {
        int item = 1;
        MyQueue<Integer> queue = new MyQueue<>();

        queue.enqueue(item);

        assertThat(queue.getCount()).isEqualTo(1);
        // Проверяем, что элемент добавился как первый
        Iterator<Integer> iterator = queue.iterator();
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isEqualTo(item);
    }

    @Test
    void enqueue_NonEmptyQueue_AddsElement() {
        int firstItem = 1;
        int secondItem = 2;
        MyQueue<Integer> queue = new MyQueue<>(firstItem);

        queue.enqueue(secondItem);

        assertThat(queue.getCount()).isEqualTo(2);
        
        // Проверяем порядок: первый элемент должен остаться первым
        Iterator<Integer> iterator = queue.iterator();
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isEqualTo(firstItem);
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isEqualTo(secondItem);
    }

    @Test
    void queue_EmptyQueue_AddsElement() {
        int item = 1;
        MyQueue<Integer> queue = new MyQueue<>();

        queue.queue(item);

        assertThat(queue.getCount()).isEqualTo(1);
        // Проверяем, что элемент добавился как первый
        Iterator<Integer> iterator = queue.iterator();
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isEqualTo(item);
    }

    @Test
    void queue_NonEmptyQueue_AddsElement() {
        int firstItem = 1;
        int secondItem = 2;
        MyQueue<Integer> queue = new MyQueue<>(firstItem);

        queue.queue(secondItem);

        assertThat(queue.getCount()).isEqualTo(2);
        
        // Проверяем порядок: первый элемент должен остаться первым
        Iterator<Integer> iterator = queue.iterator();
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isEqualTo(firstItem);
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isEqualTo(secondItem);
    }

    @Test
    void fifoOrder_EnqueueAndDequeue_MaintainsCorrectOrder() {
        MyQueue<String> queue = new MyQueue<>();
        
        // Добавляем элементы
        queue.enqueue("first");
        queue.enqueue("second");
        queue.enqueue("third");
        
        // Извлекаем в том же порядке (FIFO)
        assertThat(queue.dequeue()).isEqualTo("first");
        assertThat(queue.dequeue()).isEqualTo("second");
        assertThat(queue.dequeue()).isEqualTo("third");
        
        assertThat(queue).isEmpty();
    }

    @Test
    void iterator_EmptyQueue_HasNoElements() {
        MyQueue<Integer> queue = new MyQueue<>();
        Iterator<Integer> iterator = queue.iterator();
        
        assertThat(iterator.hasNext()).isFalse();
        assertThatThrownBy(iterator::next)
                .isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void iterator_WithElements_IteratesInCorrectOrder() {
        var items = Arrays.asList(1, 2, 3, 4);
        MyQueue<Integer> queue = new MyQueue<>(items);
        
        int index = 0;
        for (Integer item : queue) {
            assertThat(item).isEqualTo(items.get(index));
            index++;
        }
        assertThat(index).isEqualTo(items.size());
    }

    @Test
    void mixedOperations_EnqueueDequeueSequence_WorksCorrectly() {
        MyQueue<Integer> queue = new MyQueue<>();
        
        // Добавляем некоторые элементы
        queue.enqueue(1);
        queue.enqueue(2);
        assertThat(queue.getCount()).isEqualTo(2);
        
        // Извлекаем один
        assertThat(queue.dequeue()).isEqualTo(1);
        assertThat(queue.getCount()).isEqualTo(1);
        
        // Добавляем еще
        queue.enqueue(3);
        queue.enqueue(4);
        assertThat(queue.getCount()).isEqualTo(3);
        
        // Извлекаем все остальные
        assertThat(queue.dequeue()).isEqualTo(2);
        assertThat(queue.dequeue()).isEqualTo(3);
        assertThat(queue.dequeue()).isEqualTo(4);
        
        assertThat(queue).isEmpty();
    }

    @Test
    void tryDequeue_WithStringType_WorksCorrectly() {
        MyQueue<String> queue = new MyQueue<>("test");
        MyQueue.Holder<String> holder = new MyQueue.Holder<>();
        
        boolean result = queue.tryDequeue(holder);
        
        assertThat(result).isTrue();
        assertThat(holder.value).isEqualTo("test");
        assertThat(queue).isEmpty();
    }

    @Test
    void getCount_ReturnsCorrectValue() {
        MyQueue<Integer> queue = new MyQueue<>();
        assertThat(queue.getCount()).isZero();
        
        queue.enqueue(1);
        assertThat(queue.getCount()).isEqualTo(1);
        
        queue.enqueue(2);
        assertThat(queue.getCount()).isEqualTo(2);
        
        queue.dequeue();
        assertThat(queue.getCount()).isEqualTo(1);
        
        queue.dequeue();
        assertThat(queue.getCount()).isZero();
    }
}
