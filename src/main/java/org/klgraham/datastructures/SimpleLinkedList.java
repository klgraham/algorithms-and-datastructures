package org.klgraham.datastructures;

/**
 * Created by klogram on 10/12/16.
 */
public class SimpleLinkedList<T extends Comparable<T>> {
    private T item;
    private SimpleLinkedList<T> next;

    public SimpleLinkedList() {
        this.item = null;
        this.next = null;
    }

    public SimpleLinkedList<T> find(T item){
        return find(item, SimpleLinkedList.this);
    }

    private SimpleLinkedList<T> find(T item, SimpleLinkedList<T> list) {
        if (list == null) {
            return null;
        }

        if (list.item.equals(item)) {
            return list;
        }
        else {
            return find(item, list.next);
        }
    }

    public void add(T item) {
        if (this.item == null) {
            this.item = item;
        }
        else {
            SimpleLinkedList<T> node = new SimpleLinkedList<T>();
            node.item = item;
            node.next = this.next;
            this.next = node;
        }
    }

    public void remove(T item) {
        SimpleLinkedList<T> node = find(item);

        if (node != null) {
            SimpleLinkedList<T> prev = getParent(item, SimpleLinkedList.this);
            if (prev == null) {
                SimpleLinkedList.this.item = item;
                SimpleLinkedList.this.next = node.next;
            }
            else {
                prev.next = node.next;
            }
        }
    }

    private SimpleLinkedList<T> getParent(T item, SimpleLinkedList<T> list) {
        if (list == null || list.next == null) {
            return null;
        }

        if (list.next.item.equals(item)){
            return list;
        }
        else {
            return getParent(item, list.next);
        }
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public SimpleLinkedList<T> getNext() {
        return next;
    }

    public void setNext(SimpleLinkedList<T> next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SimpleLinkedList<?> that = (SimpleLinkedList<?>) o;

        return item != null ? item.equals(that.item) : that.item == null;

    }

}
