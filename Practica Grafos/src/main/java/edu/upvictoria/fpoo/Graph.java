package edu.upvictoria.fpoo;

import java.util.*;

public abstract class Graph<T> implements GraphUtils<T> {
    protected Map<T, List<Nodo<T>>> vertices;

    public Graph() {
        this.vertices = new HashMap<>();
    }

    public Map<T, List<Nodo<T>>> getVertices() {
        return vertices;
    }

    public void setVertices(Map<T, List<Nodo<T>>> vertices) {
        this.vertices = vertices;
    }

    public List<Nodo<T>> getAdjacentVertices(T vertex) {
        List<Nodo<T>> adjacentVertices = new ArrayList<>();
        List<Nodo<T>> nodes = vertices.get(vertex);

        if (nodes != null) {
            adjacentVertices.addAll(nodes);
        }

        return adjacentVertices;
    }

    public boolean hasVertex(T vertex) {
        return vertices.containsKey(vertex);
    }

    public void addVertex(T vertex) {
        if (!hasVertex(vertex)) {
            vertices.put(vertex, new ArrayList<>());
        }
    }

    public static class Nodo<T> {
        private T data;

        public Nodo(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }
}
