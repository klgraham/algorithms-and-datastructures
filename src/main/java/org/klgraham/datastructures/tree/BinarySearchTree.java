package org.klgraham.datastructures.tree;

/**
 * Created by klogram on 10/12/16.
 */
public class BinarySearchTree<T extends Comparable<T>> implements BST<T> {

    T item;
    BST<T> left;
    BST<T> right;
    BST<T> parent;

    public BinarySearchTree() {
    }

    @Override
    public BST<T> search(T item) {
        return search(item, this);
    }

    @Override
    public BST<T> findMinimum() {
        return null;
    }

    @Override
    public BST<T> previous() {
        return null;
    }

    @Override
    public BST<T> next() {
        return null;
    }

    @Override
    public BST<T> insert(T item) {
        return null;
    }

    @Override
    public BST<T> delete(T item) {
        return null;
    }

    private BST<T> search(T item, BST<T> tree) {
//        while (tree != null && item.equals(tree.item))
        return null;
    }

    @Override
    public T getItem() {
        return null;
    }
}
