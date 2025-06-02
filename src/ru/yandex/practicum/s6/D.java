package ru.yandex.practicum.s6;

import java.util.*;

public class D {

    private static List<String> color = new ArrayList<>();
    private static List<AbstractMap.SimpleEntry<Integer, Integer>> graph;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            var line = scanner.nextLine().split(" ");
            var vertexCount = Integer.parseInt(line[0]);
            var edgeCount = Integer.parseInt(line[1]);

            init(vertexCount);

            graph = readEdges(scanner, edgeCount);

            var startPoint = Integer.parseInt(scanner.nextLine());

            bfs(startPoint);
        }
    }

    private static void bfs(int startPoint) {
        Queue<Integer> planned = new LinkedList<>();
        planned.add(startPoint);
        color.set(startPoint - 1, "gray");
        StringJoiner joiner = new StringJoiner(" ");

        while (!planned.isEmpty()) {
            var u = planned.poll();
            joiner.add(Integer.toString(u));

            for (var v : outgoingEdges(u)) {
                if (color.get(v - 1).equals("white")) {
                    color.set(v - 1, "gray");
                    planned.add(v);
                }
            }
        }

        System.out.println(joiner);
    }

    private static void init(int vertexCount) {
        for (int i = 0; i < vertexCount; i++) {
            color.add("white");
        }
    }

    private static List<Integer> outgoingEdges(int u) {
        var result = new ArrayList<Integer>();
        for (AbstractMap.SimpleEntry<Integer, Integer> uv : graph) {
            if (uv.getKey().equals(u) || uv.getValue().equals(u)) {
                result.add(uv.getKey());
                result.add(uv.getValue());
            }
        }

        Collections.sort(result);
        return result;
    }

    private static List<AbstractMap.SimpleEntry<Integer, Integer>> readEdges(Scanner scanner, int edgeCount) {
        var edges = new ArrayList<AbstractMap.SimpleEntry<Integer, Integer>>();

        for (int i = 0; i < edgeCount; i++) {
            String[] points = scanner.nextLine().split(" ");
            var edge = new AbstractMap.SimpleEntry<>(
                    Integer.parseInt(points[0]),
                    Integer.parseInt(points[1])
            );
            edges.add(edge);
        }

        return edges;
    }
}
