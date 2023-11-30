package Hands_On_4;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        
        Graph graph = new Graph();

        graph.addEdge("a", "b", 100);
        graph.addEdge("a", "c", 125);
        graph.addEdge("a", "d", 100);
        graph.addEdge("a", "e", 75);

        graph.addEdge("b", "a", 100);
        graph.addEdge("b", "c", 50);
        graph.addEdge("b", "d", 75);
        graph.addEdge("b", "e", 125);

        graph.addEdge("c", "a", 125);
        graph.addEdge("c", "b", 50);
        graph.addEdge("c", "d", 100);
        graph.addEdge("c", "e", 125);

        graph.addEdge("d", "a", 100);
        graph.addEdge("d", "b", 75);
        graph.addEdge("d", "c", 100);
        graph.addEdge("d", "e", 50);

        graph.addEdge("e", "a", 75);
        graph.addEdge("e", "b", 125);
        graph.addEdge("e", "c", 125);
        graph.addEdge("e", "d", 50);

        graph.printGraph();

        List<String> path = graph.shortestPath();

        System.out.println("");
        System.out.println("Shortest path: " + path);
        
    }
}
