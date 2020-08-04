package io.github.yurigivo.math;

import java.util.AbstractMap.SimpleEntry;
import java.util.*;
import java.util.Map.Entry;

public class TopologicalSorting {
    private final List<Entry<String, String>> nodes;

    public TopologicalSorting(List<Entry<String, String>> nodes) {
        this.nodes = nodes;
    }

    public List<Entry<String, String>> getReconstructedGraph() {
        Map<String, String> edges = new HashMap<>();
        for (Entry<String, String> node : this.nodes)
            edges.put(node.getKey(), node.getValue());

        Set<String> visited = new HashSet<>();
        Stack<String> graph = new Stack<>();
        for (Entry<String, String> next : this.nodes) {
            Stack<String> subGraph = new Stack<>();
            String node = next.getKey();
            while (node != null && !visited.contains(node)) {
                subGraph.push(node);
                visited.add(node);
                node = edges.get(node);
            }
            while (!subGraph.empty())
                graph.push(subGraph.pop());
        }

        List<Entry<String, String>> result = new ArrayList<>(this.nodes.size());
        while (!graph.empty()) {
            String from = graph.pop();
            String to = edges.get(from);
            if (to != null)
                result.add(new SimpleEntry<>(from, to));
        }
        return result;
    }
}
