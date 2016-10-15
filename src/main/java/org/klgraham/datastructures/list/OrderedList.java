//package org.klgraham.datastructures;
//
//import java.util.Optional;
//
///**
// * Created by klogram on 10/3/16.
// */
//public class OrderedList<T extends Comparable<T>> {
//    private Node<T> head;
//    private Node<T> current;
//
//    public OrderedList(T item) {
//        Node<T> node = new Node<T>(item);
//        this.head = node;
//        current = null;
//    }
//
//    public boolean isEmpty() {
//        return head == null;
//    }
//
//    public void append(T item) {
//        Node<T> node = new Node<T>(item);
//        if (this.isEmpty()) {
//            head = node;
//        }
//        else {
//            Node n = head;
//            while (n.next.isPresent()) {
//                n = (Node) n.getNext().get();
//            }
//
//            n.next = Optional.of(node);
//        }
//    }
//
//    public void insert(T item) {
//        Node<T> previous = head;
//        Node<T> node = new Node<T>(item);
//
//        Node<T> n = head;
//        while (n.item.compareTo(item) < 0) {
//            previous = previous.next.get();
//        }
//
//        // previous will now be the node < item
//        Node<T> nextNode = previous.next.get();
//
//        previous.next = Optional.of(node);
//        node.next = Optional.of(nextNode);
//    }
//
//
//
//
//}
