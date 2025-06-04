package ru.yandex.practicum.s6;

import java.util.*;

public class E {

    private static List<Boolean> visited = new ArrayList<>();
    private static List<List<Integer>> graph = new ArrayList<>();
    private static List<List<Integer>> components = new ArrayList<>();


    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            var line = scanner.nextLine().split(" ");
            var vertexCount = Integer.parseInt(line[0]);
            var edgeCount = Integer.parseInt(line[1]);

            init(vertexCount);

            graph = readEdges(scanner, edgeCount);

            for (int i = 1; i <= vertexCount; i++) {
                if (visited.get(i)) {
                    continue;
                }

                var planned = new ArrayDeque<Integer>();
                planned.add(i);
                visited.set(i, true);

                var component = new ArrayList<Integer>();
                while (!planned.isEmpty()) {
                    var u = planned.poll();
                    component.add(u);
                    var vertexes = graph.get(u);
                    for (var v : vertexes) {
                        if (!visited.get(v)) {
                            visited.set(v, true);
                            planned.add(v);
                        }
                    }

                }
                components.add(component);
            }

            System.out.println(components.size());
            components.forEach(component -> {
                var joiner = new StringJoiner(" ");
                component.stream().sorted().forEach(x -> {
                    joiner.add(Integer.toString(x));
                });
                System.out.println(joiner);
            });
        }
    }

    private static void init(int vertexCount) {
        for (int i = 0; i <= vertexCount + 1; i++) {
            visited.add(false);
            graph.add(new ArrayList<>());
        }
    }


    private static List<List<Integer>> readEdges(Scanner scanner, int edgeCount) {
        for (int i = 0; i < edgeCount; i++) {
            String[] points = scanner.nextLine().split(" ");
            var u = Integer.parseInt(points[0]);
            var v = Integer.parseInt(points[1]);

            var vertexU = graph.get(u);
            vertexU.add(v);

            var vertexV = graph.get(v);
            vertexV.add(u);

        }

        return graph;
    }
}

