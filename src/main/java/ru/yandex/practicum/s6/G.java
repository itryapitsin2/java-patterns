package ru.yandex.practicum.s6;

import java.util.*;

public class G {

    private static List<Boolean> visited = new ArrayList<>();
    private static List<List<Integer>> graph = new ArrayList<>();
    private static List<Integer> distance = new ArrayList<>();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            var line = scanner.nextLine().split(" ");
            var vertexCount = Integer.parseInt(line[0]);
            var edgeCount = Integer.parseInt(line[1]);

            init(vertexCount);

            graph = readEdges(scanner, edgeCount);

            line = scanner.nextLine().split(" ");

            var startPoint = Integer.parseInt(line[0]);

            bfs(startPoint);
        }
    }

    private static void bfs(int startPoint) {
        Queue<Integer> planned = new ArrayDeque<>();
        planned.add(startPoint);
        visited.set(startPoint, true);
        distance.set(startPoint, 0);

        while (!planned.isEmpty()) {
            var u = planned.poll();

            var vertexes = graph.get(u);

            for (var v : vertexes) {
                if (!visited.get(v)) {
                    visited.set(v, true);
                    if (v != startPoint) {
                        distance.set(v, distance.get(u) + 1);
                        planned.add(v);
                    }
                }
            }
        }

        System.out.println(Collections.max(distance));
    }

    private static void init(int vertexCount) {
        for (int i = 0; i <= vertexCount + 1; i++) {
            visited.add(false);
            graph.add(new ArrayList<>());
            distance.add(0);
        }
    }


    private static List<List<Integer>> readEdges(Scanner scanner, int edgeCount) {
        for (int i = 0; i < edgeCount; i++) {
            String[] points = scanner.nextLine().split(" ");
            var u = Integer.parseInt(points[0]);
            var v = Integer.parseInt(points[1]);

            var vertexU = graph.get(u);
            vertexU.add(v);
            Collections.reverse(vertexU);

            var vertexV = graph.get(v);
            vertexV.add(u);
            Collections.reverse(vertexV);
        }

        return graph;
    }
}

