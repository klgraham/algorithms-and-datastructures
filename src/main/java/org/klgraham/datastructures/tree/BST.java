package org.klgraham.datastructures.tree;

/**
 * Binary Search Tree
 */
interface BST<T extends Comparable<T>> {
    BST<T> search(T item);
    BST<T> findMinimum();
//    BST<T> traverse();
    BST<T> previous();
    BST<T> next();
    BST<T> insert(T item);
    BST<T> delete(T item);

    T getItem();
}
