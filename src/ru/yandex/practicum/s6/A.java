package ru.yandex.practicum.s6;

import java.util.AbstractMap.SimpleEntry;
import java.util.*;
import java.util.stream.Collectors;

public class A {

    private static class Vertex {
        List<Integer> vertexes;

        public Vertex(List<Integer> vertexes) {
            this.vertexes = vertexes;
        }

        @Override
        public String toString() {
            var joiner = new StringJoiner(" ");

            Collections.sort(vertexes);

            joiner.add(Integer.toString(vertexes.size()));

            vertexes.forEach(x -> joiner.add(Integer.toString(x)));

            return joiner.toString();
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            var line = scanner.nextLine().split(" ");
            var vertexCount = Integer.parseInt(line[0]);
            var edgeCount = Integer.parseInt(line[1]);

            var edges = readEdges(scanner, edgeCount);
            var vertexes = calVertexes(vertexCount, edges);

            vertexes.forEach(vertex -> System.out.println(vertex.toString()));
        }
    }

    private static List<Vertex> calVertexes(int vertexCount, List<SimpleEntry<Integer, Integer>> edges) {
        var vertexes = new ArrayList<Vertex>();

        for (int i = 1; i <= vertexCount; i++) {
            int finalI = i;
            var vertexesOfEdge = edges.stream()
                    .filter(edge -> edge.getKey().equals(finalI))
                    .map(SimpleEntry::getValue)
                    .collect(Collectors.toList());
            vertexes.add(new Vertex(vertexesOfEdge));
        }

        return vertexes;
    }

    private static List<SimpleEntry<Integer, Integer>> readEdges(Scanner scanner, int edgeCount) {
        List<SimpleEntry<Integer, Integer>> edges = new ArrayList<>();

        for (int i = 0; i < edgeCount; i++) {
            String[] points = scanner.nextLine().split(" ");
            var edge = new SimpleEntry<>(
                    Integer.parseInt(points[0]),
                    Integer.parseInt(points[1])
            );
            edges.add(edge);
        }

        return edges;
    }
}
