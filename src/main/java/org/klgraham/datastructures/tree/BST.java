package org.klgraham.datastructures.tree;

/**
 * Binary Search Tree
 *
 * For a given node, x, in the tree, all nodes in the left subtree of x are
 * <= x.key and all nodes in the right subtree of x are >= x.key.
 *
 * This is implemented in a way that makes the recursive nature of the tree
 * apparent.
 *
 * @author Kenneth Graham
 */
public class BST<K extends Comparable<K> , V> {

    private K key;
    private V item;
    private BST<K, V> left;
    private BST<K, V> right;
    private BST<K, V> parent;

//    public static void main(String[] args) {
//        BST<Integer, In
//    }

    public BST() {
    }

    public BST<K, V> insert(K item) {
        return null;
    }

    public BST<K, V> delete(K item) {
        return null;
    }

    public BST<K, V> search(K item) {
        return search(item, this);
    }

    /**
     * Returns the node containing the smallest key in the tree
     * @return
     */
    public BST<K, V> findMinimum() {
        BST<K, V> x = this;
        while (x.left != null) {
            x = x.left;
        }
        return x;
    }

    /**
     * Returns the node containing the largest key in the tree
     * @return
     */
    public BST<K, V> findMaximum() {
        BST<K, V> x = this;
        while (x.right != null) {
            x = x.right;
        }
        return x;
    }

    /**
     * Returns the previous node in the sorted order.
     * The previous node has the largest key larger than the current node's key.
     * @return Successor node of the input
     */
    public BST<K, V> previous() {
        return null;
    }

    /**
     * Returns the next node in the sorted order.
     * The next node has the smallest key larger than this node's key.
     * @return Successor node of the input
     */
    public BST<K, V> next() {
        // return the smallest member of the right subtree, if possible
        if (this.right != null) {
            return this.right.findMinimum();
        }


    }

    private BST<K, V>  search(K key, BST<K, V> tree) {
        BST<K, V> x = tree;

        /*
         iterate while the subtree exists and this node's key
         isn't the one we want
          */
        while (x != null && !key.equals(tree.key)) {
            // if key < x.key, look to left subtree
            if (key.compareTo(x.key) < 0) {
                x = x.left;
            }
            else {
                // look to the right subtree
                x = x.right;
            }
        }

        return x;
    }

    /**
     * Walks the tree in order, printing each item
     */
    public void printInOrder() {
        this.left.printInOrder();
        System.out.println(key);
        this.right.printInOrder();
    }

    @Override
    public String toString() {
        return "BST{" +
                "key=" + key +
                ", item=" + item +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public K getItem() {
        return null;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setItem(V item) {
        this.item = item;
    }

    public BST<K, V> getLeft() {
        return left;
    }

    public void setLeft(BST<K, V> left) {
        this.left = left;
    }

    public BST<K, V> getRight() {
        return right;
    }

    public void setRight(BST<K, V> right) {
        this.right = right;
    }
}
