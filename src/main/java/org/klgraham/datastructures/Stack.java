package org.klgraham.datastructures;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Created by klogram on 8/6/16.
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

    public void push(T item) {
        stack.add(item);
    }

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
