package org.klgraham.datastructures.graph;

/**
 * Created by klogram on 10/19/16.
 */
public interface Graph {
    int numberOfVertices();
    int numberOfEdges();

    /**
     * Add edge between vertex A and vertex B.
     * @param a index of vertex A
     * @param b index of vertex B
     */
    void addEdge(int a, int b);

    /**
     * Get iterable over vertices adjacent to vertex A
     * @param a
     * @return
     */
    Iterable<Integer> adj(int a);
}
