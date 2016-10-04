package org.klgraham.datastructures;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * A Stack works like a stack of papers on a desk. You add things to the top
 * and remove things from the top. Older items are at the bottom of the stack.
 * This is a last in, first out (LIFO) process.
 * @author Kenneth Graham
 */
public class Stack<T> implements Iterable<T> {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= 7; i++) {
            stack.push(i);
        }

        System.out.println("Items added, shown in order, with foreach");
        stack.forEach(i -> System.out.println(i));

        System.out.println("Items added (LIFO):");
        for (int i = 0; i <= 7; i++) {
            System.out.println(stack.pop());
        }
    }

    List<T> stack;

    public Stack() {
        this.stack = new ArrayList<T>();
    }

    /**
     * Adds one item to the top of the stack.
     * @param item
     */
    public void push(T item) {
        stack.add(item);
    }

    /**
     * Returns the item at the top of the stack without removing it.
     * @return item
     */
    public T peek() {
        return stack.get(stack.size() - 1);
    }

    /**
     * Removes an item from the top of the stack.
     * @return the removed item
     */
    public T pop() {
        return stack.remove(stack.size() - 1);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }

    @Override
    public Iterator<T> iterator() {
        return stack.iterator();
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        stack.forEach(action);
    }

    @Override
    public Spliterator<T> spliterator() {
        return stack.spliterator();
    }
}
