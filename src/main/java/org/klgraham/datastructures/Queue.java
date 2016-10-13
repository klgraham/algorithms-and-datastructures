package org.klgraham.datastructures;

import java.util.*;
import java.util.function.Consumer;

/**
 * A Queue is a waiting line. Items are added to the back of the queue and are
 * removed from the front of the queue. Older items are at the front. This is
 * a first in, first out (FIFO) process.
 * @author Kenneth Graham
 */
public class Queue<T> implements Iterable<T> {

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        for (int i = 0; i <= 7; i++) {
            queue.enqueue(i);
        }

        System.out.println("Items added, shown in order, with foreach");
        queue.forEach(i -> System.out.println(i));

        System.out.println("Items added (FIFO):");
        for (int i = 0; i <= 7; i++) {
            System.out.println(queue.dequeue());
        }
    }

    public Queue() {
        this.queue = new LinkedList<T>();
    }

    List<T> queue;

    /**
     * Adds an item to the back of the queue.
     * @param item
     */
    public void enqueue(T item) {
        queue.add(item);
    }

    /**
     * Removes an item from the front of the queue and returns it.
     * @return the item
     */
    public T dequeue() {
        return queue.remove(0);
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }

    @Override
    public Iterator<T> iterator() {
        return queue.iterator();
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        queue.forEach(action);
    }

    @Override
    public Spliterator<T> spliterator() {
        return queue.spliterator();
    }
}
