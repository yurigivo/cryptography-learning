package io.github.yurigivo.math;

import org.junit.Test;

import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;

import static org.junit.Assert.assertEquals;

public class TopologicalSortingTest {
    @Test public void reconstructsGraph() {
        List<Entry<String, String>> nodes = Arrays.asList(
                new SimpleEntry<>("C", "D"),
                new SimpleEntry<>("A", "B"),
                new SimpleEntry<>("D", "E"),
                new SimpleEntry<>("B", "C"),
                new SimpleEntry<>("E", "F")
        );
        List<Entry<String, String>> graph = new TopologicalSorting(nodes).getReconstructedGraph();
        assertEquals(5, graph.size());
        assertEquals(new SimpleEntry<>("A", "B"), graph.get(0));
        assertEquals(new SimpleEntry<>("B", "C"), graph.get(1));
        assertEquals(new SimpleEntry<>("C", "D"), graph.get(2));
        assertEquals(new SimpleEntry<>("D", "E"), graph.get(3));
        assertEquals(new SimpleEntry<>("E", "F"), graph.get(4));
    }
}