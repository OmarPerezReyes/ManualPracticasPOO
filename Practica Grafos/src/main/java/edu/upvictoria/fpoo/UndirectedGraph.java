package edu.upvictoria.fpoo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UndirectedGraph<T> extends Graph<T> {
    public UndirectedGraph() {
        super();
    }

    @Override
    public void addEdge(T sourceVertex, T destinationVertex) {
        if (hasVertex(sourceVertex) && hasVertex(destinationVertex)) {
            List<Nodo<T>> sourceNeighbors = vertices.get(sourceVertex);
            List<Nodo<T>> destinationNeighbors = vertices.get(destinationVertex);

            sourceNeighbors.add(new Nodo<>(destinationVertex));
            destinationNeighbors.add(new Nodo<>(sourceVertex));
        }
    }

    @Override
    public void printGraph() {
        for (Map.Entry<T, List<Nodo<T>>> entry : vertices.entrySet()) {
            T vertex = entry.getKey();
            List<Nodo<T>> neighbors = entry.getValue();
            System.out.print(vertex + " -> ");
            for (Nodo<T> neighbor : neighbors) {
                System.out.print(neighbor.getData() + " ");
            }
            System.out.println();
        }
    }
}
