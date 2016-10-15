package org.klgraham.datastructures;

import org.klgraham.datastructures.list.DoublyLinkedList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * Chained hash table
 *
 * @author Kenneth Graham
 */
public class HashTable<T extends Comparable<T>> {
    private Map<Integer, DoublyLinkedList<T>> table;
    private static final int initialCapacity = 100000;

    public HashTable() {
        this.table = new HashMap<>(initialCapacity, 0.000001f);
    }

    /**
     * Insert item into the hash table, at the head of the slot's chain
     * @param x
     */
    public void insert(T x) {
        int index = hashcodeToArrayIndex(x.hashCode());
        DoublyLinkedList<T> chain = table.getOrDefault(index, new DoublyLinkedList<>());
        chain.add(0, x);
        table.put(index, chain);
    }

    public void delete(T x) {
        int index = hashcodeToArrayIndex(x.hashCode());
        DoublyLinkedList<T> chain = table.getOrDefault(index, new DoublyLinkedList<>());
        if (chain != null) {
            chain.remove(x);
        }
    }

    public boolean contains(int key) {
        int index = hashcodeToArrayIndex(key);
        DoublyLinkedList<T> chain = table.getOrDefault(index, new DoublyLinkedList<>());
        return chain != null && !chain.isEmpty();
    }

    public T search(int key) {
        if (this.contains(key)) {
            int index = hashcodeToArrayIndex(key);
            DoublyLinkedList<T> chain = table.getOrDefault(index, new DoublyLinkedList<>());
            if (chain != null && !chain.isEmpty()) {
                return chain.getHead().getData();
            }
        }
        return null;
    }

    private int hashcodeToArrayIndex(int hashcode) {
        return (hashcode & 0x7fffffff) % initialCapacity;
    }
}
