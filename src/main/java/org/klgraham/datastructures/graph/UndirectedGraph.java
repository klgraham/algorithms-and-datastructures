package org.klgraham.datastructures.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by klogram on 10/19/16.
 */
public class UndirectedGraph implements Graph {

    private final int numberOfVertices;
    private int numberOfEdges;
    private List<List<Integer>> adjacenyList;

    public UndirectedGraph(int vertexCount) {
        this.numberOfVertices = vertexCount;
        this.numberOfEdges = 0;

        this.adjacenyList = new ArrayList<>(vertexCount);
        for (int v = 0; v < vertexCount; v++) {
            this.adjacenyList.add(new ArrayList<Integer>());
        }
    }

    @Override
    public int numberOfVertices() {
        return numberOfVertices;
    }

    @Override
    public int numberOfEdges() {
        return numberOfEdges;
    }

    @Override
    public void addEdge(int a, int b) {
        adjacenyList.get(a).add(b);
        adjacenyList.get(b).add(a);
        numberOfEdges++;
    }

    @Override
    public Iterable<Integer> adj(int a) {
        return adjacenyList.get(a);
    }

    public int degree(int v) {
        return adjacenyList.get(v).size();
    }

    public int getNumberOfSelfLoops() {
        int count = 0;
        for (int v = 0; v < numberOfVertices; v++) {
            for (int neighbor : adjacenyList.get(v)) {
                if (v == neighbor) {
                    count++;
                }
            }
        }
        return count;
    }


}
