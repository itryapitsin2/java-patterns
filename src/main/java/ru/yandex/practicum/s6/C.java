package ru.yandex.practicum.s6;

import java.util.*;

public class C {
    private static Map<Integer, List<Integer>> graph;
    private static Map<Integer, String> color = new HashMap<>();


    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            var line = scanner.nextLine().split(" ");
            var vertexCount = Integer.parseInt(line[0]);
            var edgeCount = Integer.parseInt(line[1]);

            init(vertexCount);

            graph = readEdges(scanner, edgeCount);

            var startPoint = Integer.parseInt(scanner.nextLine());

            dfs(startPoint);
        }
    }

    private static void dfs(int startPoint) {
        var stack = new Stack<Integer>();
        stack.push(startPoint);

        StringJoiner joiner = new StringJoiner(" ");

        while(!stack.isEmpty()) {
            var v = stack.pop();

            if (color.get(v).equals("white")) {
                color.put(v, "grey");
                stack.push(v);
                joiner.add(Integer.toString(v));

                for (var u : graph.get(v)) {
                    if (color.get(u).equals("white")) {
                        stack.push(u);
                    }
                }

            } else if (color.get(v).equals("grey")) {
                color.put(v, "black");
            }
        }

    }

    private static void init(int vertexCount) {
        for (int i = 1; i <= vertexCount; i++) {
            color.put(i, "white");
        }
    }

    private static Map<Integer, List<Integer>> readEdges(Scanner scanner, int edgeCount) {
        var graph = new HashMap<Integer, List<Integer>>();

        for (int i = 0; i < edgeCount; i++) {
            String[] points = scanner.nextLine().split(" ");
            var u = Integer.parseInt(points[0]);
            var v = Integer.parseInt(points[1]);

            if (graph.containsKey(u)) {
                var vertexU = graph.get(u);
                vertexU.add(v);
                Collections.reverse(vertexU);
            } else {
                var destinations = new ArrayList<Integer>();
                destinations.add(v);
                graph.put(u, destinations);
            }

            if (graph.containsKey(v)) {
                var vertexV = graph.get(v);
                vertexV.add(u);
                Collections.reverse(vertexV);
            } else {
                var destinations = new ArrayList<Integer>();
                destinations.add(u);
                graph.put(v, destinations);
            }
        }

        return graph;
    }
}
