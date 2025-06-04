package ru.yandex.practicum.s6;

import java.util.*;

public class F {
    private static boolean[] color;
    private static int[][] graph;
    private static int[] distance;


    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            var line = scanner.nextLine().split(" ");
            var vertexCount = Integer.parseInt(line[0]);
            var edgeCount = Integer.parseInt(line[1]);

            color = new boolean[vertexCount + 1];
            graph = new int[vertexCount + 1][];
            distance = new int[vertexCount + 1];

            init(vertexCount);

//            graph = readEdges(scanner, edgeCount);

            line = scanner.nextLine().split(" ");

            var startPoint = Integer.parseInt(line[0]);
            var endPoint = Integer.parseInt(line[1]);

            bfs(startPoint, endPoint);
        }
    }

    private static void bfs(int startPoint, int endPoint) {
        Queue<Integer> planned = new ArrayDeque<>();
        planned.add(startPoint);
        color[startPoint] = true;
        distance[startPoint] = 0;

        while (!planned.isEmpty()) {
            var u = planned.poll();

            var vertexes = graph[u];
            if (vertexes == null) {
                continue;
            }

            for (var v : vertexes) {
                if (!color[v]) {
                    color[v] = true;
                    if (v != startPoint) {
                        distance[v] = distance[u] + 1;
                    }
                    planned.add(v);
                }
            }
        }

        System.out.println(distance[endPoint]);
    }

    private static void init(int vertexCount) {
        for (int i = 0; i <= vertexCount + 1; i++) {
            color[i] = false;
            graph[i] = new int[vertexCount+1];
            distance[i] = -1;
        }
    }


    private static void readEdges(Scanner scanner, int edgeCount) {
        for (int i = 0; i < edgeCount; i++) {
            String[] points = scanner.nextLine().split(" ");
            var u = Integer.parseInt(points[0]);
            var v = Integer.parseInt(points[1]);

            var vertexU = graph[u];
//            vertexU.add(v);

            var vertexV = graph[v];
//            vertexV.add(u);
        }

//        return graph;
    }
}

