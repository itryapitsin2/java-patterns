package ru.yandex.practicum.s6;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

public class B {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            var line = scanner.nextLine().split(" ");
            var vertexCount = Integer.parseInt(line[0]);
            var edgeCount = Integer.parseInt(line[1]);

            var edges = readEdges(scanner, edgeCount);

            for (int u = 1; u <= vertexCount; u++) {
                var joiner = new StringJoiner(" ");
                for (int v = 1; v <= vertexCount; v++) {
                    joiner.add(
                            hasEdge(u, v, edges)
                                    ? Integer.toString(1)
                                    : Integer.toString(0)
                    );
                }
                System.out.println(joiner);
            }
        }
    }

    private static boolean hasEdge(int u, int v, List<SimpleEntry<Integer, Integer>> edges) {
        return edges.stream().anyMatch(edge -> edge.getKey().equals(u) && edge.getValue().equals(v));
    }

    private static List<SimpleEntry<Integer, Integer>> readEdges(Scanner scanner, int edgeCount) {
        var edges = new ArrayList<SimpleEntry<Integer, Integer>>();

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
