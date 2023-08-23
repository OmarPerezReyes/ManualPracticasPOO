package edu.upvictoria.fpoo;

import java.util.ArrayList;
import java.util.List;

public class DirectedGraph<T> extends Graph<T> {

    public DirectedGraph() {
        super();
    }

    @Override
    public void addEdge(T sourceVertex, T destinationVertex) {
        if (vertices.containsKey(sourceVertex) && vertices.containsKey(destinationVertex)) {
            List<Nodo<T>> neighbors = vertices.get(sourceVertex);
            neighbors.add(new Nodo<>(destinationVertex));
        }
    }

    public boolean hasEdge(T source, T destination) {
        List<Nodo<T>> neighbors = vertices.get(source);
        if (neighbors != null) {
            for (Nodo<T> neighbor : neighbors) {
                if (neighbor.getData().equals(destination)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void printGraph() {
        for (T vertex : vertices.keySet()) {
            List<Nodo<T>> neighbors = vertices.get(vertex);
            if (neighbors != null) {
                System.out.print(vertex + " -> ");
                for (Nodo<T> neighbor : neighbors) {
                    System.out.print(neighbor.getData() + " ");
                }
                System.out.println();
            }
        }
    }
}
