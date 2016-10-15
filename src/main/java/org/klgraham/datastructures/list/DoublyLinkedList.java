package org.klgraham.datastructures.list;

import java.util.Optional;

/**
 * An doubly-linked list
 * @author Kenneth Graham
 */
public class DoublyLinkedList<T extends Comparable<T>> {
    private Node<T> head;
    private int itemCount;

    public DoublyLinkedList() {
        head = null;
        itemCount = 0;
    }

    public DoublyLinkedList(T item) {
        Node<T> node = new Node(item);
        head = node;
        itemCount = 1;
    }

    public boolean isEmpty() {
        return head == null || itemCount == 0;
    }

    /**
     * Adds an item to the end of the list
     * @param item
     */
    public void add(T item) {
        Node<T> node = new Node(item);
        if (this.isEmpty()) {
            head = node;
        }
        else {
            Node<T> cursor = head;
            while (cursor.hasNext()) {
                cursor = cursor.getNext().get();
            }

            cursor.setNext(node);
            node.setPrevious(cursor);
        }
        itemCount++;
    }

    /**
     * Insert an item at a specified position
     * @param item
     * @param index
     */
    public void add(int index, T item) {
        if (index > size()) {
            throw new IndexOutOfBoundsException(index + " is too large. There are only " + size() + " items in the list.");
        }

        Node<T> newNode = new Node(item);
        int location = 0;

        if (index == 0) {
            newNode.setNext(head);
            if (head != null) {
                head.setPrevious(newNode);
            }
            head = newNode;
        }
        else {
            Node<T> cursor = head;

            while (location < index) {
                cursor = cursor.getNext().get();
                location++;
            }

            if (cursor.hasPrevious()) {
                Node<T> prev = cursor.getPrevious().get();
                prev.setNext(newNode);
                newNode.setPrevious(prev);
            }
            newNode.setNext(cursor);
            cursor.setPrevious(newNode);
        }

        itemCount++;
    }

    public Node<T> find(T item){
        return this.find(item, Optional.ofNullable(this.head));
    }

    private Node<T> find(T item, Optional<Node<T>> node){
        if (!node.isPresent()) {
            return null;
        }

        if (node.get().getData().equals(item)) {
            return node.get();
        }
        else {
            return find(item, node.get().getNext());
        }
    }

    /**
     * Removes an item from the list and returns it
     * @param item
     * @return
     */
    public T remove(T item){
        Node<T> cursor = head;

        while (!cursor.getData().equals(item)) {
            if (cursor.hasNext()) {
                cursor = cursor.getNext().get();
            }
            else {
                throw new IllegalArgumentException(item + " is not present in the list.");
            }
        }

        // delete cursor node
        T itemRemoved = cursor.getData();
        Node<T> nextNode;
        if (cursor.hasNext()) {
            nextNode = cursor.getNext().get();
        }
        else {
            nextNode = null;
        }
        if (cursor.hasPrevious()) {
            Node<T> prev = cursor.getPrevious().get();
            prev.setNext(nextNode);
            if (nextNode != null) {
                nextNode.setPrevious(prev);
            }
        }
        itemCount--;
        cursor = null;
        return itemRemoved;
    }

    /**
     * Returns the first index of an item in the list.
     * @param item
     * @return
     */
    public int index(T item) {
        Node<T> cursor = head;
        int index = 0;

        while (!cursor.getData().equals(item)) {
            if (cursor.hasNext()) {
                cursor = cursor.getNext().get();
                index++;
            }
            else {
                throw new IllegalArgumentException(item + " is not present in the list.");
            }
        }

        return index;
    }

    /**
     * Returns and removes the item at the end of the list.
     * @return
     */
    public T pop() {
        return pop(itemCount-1);
    }

    /**
     * Returns and removes the item at the specified index
     * @param index
     * @return
     */
    public T pop(int index) {
        int counter = 0;

        Node<T> cursor = head;

        while (counter < index) {
            cursor = cursor.getNext().get();
            counter++;
        }

        T removedItem = cursor.getData();
        Node<T> nextAfterCursor = null;
        if (cursor.hasNext()) {
            nextAfterCursor = cursor.getNext().get();
        }

        if (cursor.hasPrevious()) {
            Node<T> prev = cursor.getPrevious().get();
            prev.setNext(nextAfterCursor);
            if (nextAfterCursor != null) {
                nextAfterCursor.setPrevious(prev);
            }
        }
        itemCount--;

        return removedItem;
    }

    public int size() {
        return itemCount;
    }

    public Node<T> getHead()
    {
        return head;
    }
}
