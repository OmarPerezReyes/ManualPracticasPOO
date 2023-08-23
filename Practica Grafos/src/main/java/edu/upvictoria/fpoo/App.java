package edu.upvictoria.fpoo;

public class App
{
    public static void main( String[] args ) {
        DirectedGraph<Integer> directedGraph = new DirectedGraph<>();
        directedGraph.addVertex(1);
        directedGraph.addVertex(2);
        directedGraph.addVertex(3);
        directedGraph.addEdge(1, 2);
        directedGraph.addEdge(2, 3);
        System.out.println("Grafo Dirigido:");
        directedGraph.printGraph();

        Graph<String> undirectedGraph = new UndirectedGraph<>();
        undirectedGraph.addVertex("A");
        undirectedGraph.addVertex("B");
        undirectedGraph.addVertex("C");
        undirectedGraph.addEdge("A", "B");
        undirectedGraph.addEdge("B", "C");
        System.out.println("Grafo No Dirigido:");
        undirectedGraph.printGraph();
    }
}
