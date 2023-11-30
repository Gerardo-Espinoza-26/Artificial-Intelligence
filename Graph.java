package Hands_On_4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

public class Graph {
    
    private final Map<String, Map<String, Integer>> graph;

    public Graph() {
        graph = new HashMap<>();
    }

    public void addEdge(String node1, String node2, int width) {
        graph.computeIfAbsent(node1, k -> new HashMap<>()).put(node2, width);
        graph.computeIfAbsent(node2, k -> new HashMap<>()).put(node1, width);
    }

    public int obtainWeight(String node1, String node2) {
        return graph.getOrDefault(node1, Collections.emptyMap()).getOrDefault(node2, 0);
    }
    
    public void printGraph() {
        graph.keySet().stream().map((String node1) -> {
            System.out.println("Node: " + node1);
            return node1;
        }).map((String node1) -> {
            Map<String, Integer> connections = graph.get(node1);
            connections.keySet().forEach((node2) -> {
                int width = connections.get(node2);
                System.out.println(node1 + " with Connection " + node2 + " with Width " + width);
            });
            return node1;
        }).forEachOrdered((_item) -> {
            System.out.println("");
        });
    }
    
    public List<String> shortestPath() {
        List<String> visitedNode = new ArrayList<>();
        Set<String> unVisitedNode = new HashSet<>(graph.keySet());

        visitedNode.add("a"); 
        unVisitedNode.remove("a");

        while (!unVisitedNode.isEmpty()) {
            String currentNode = visitedNode.get(visitedNode.size() - 1);
            String nextNode = null;
            int pesoMinimo = Integer.MAX_VALUE;

            for (String node : graph.get(currentNode).keySet()) {
                if (!visitedNode.contains(node) && graph.get(currentNode).get(node) < pesoMinimo) {
                    nextNode = node;
                    pesoMinimo = graph.get(currentNode).get(node);
                }
            }

            if (nextNode != null) {
                visitedNode.add(nextNode);
                unVisitedNode.remove(nextNode);
            } else {
                visitedNode.add("a");
            }
        }

        return visitedNode;
    }
    
}
