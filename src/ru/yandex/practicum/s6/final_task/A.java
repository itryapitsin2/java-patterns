package ru.yandex.practicum.s6.final_task;

import java.util.*;
import java.io.*;

/**
 * Объяснение решения сделано в файле README_A.md.
 * Ссылка на отчёт https://contest.yandex.ru/contest/25070/run-report/118149231/
 */
public class A {

    private record Edge(int from, int to, int weight) implements Comparable<Edge> {

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(o.weight, this.weight);
        }
    }

    private static final String ERROR_MESSAGE = "Oops! I did it again";

    private static final Queue<Edge> edges = new PriorityQueue<>();
    private static final List<Integer> vertexes = new ArrayList<>();
    private static final List<Edge> graph = new ArrayList<>();
    private static int maximumValue = 0;

    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

            var vertexCount = Integer.parseInt(tokenizer.nextToken());
            var edgeCount = Integer.parseInt(tokenizer.nextToken());

            initVertexes(vertexCount);
            readGraph(reader, edgeCount);
            findMaximum();

            if (vertexes.isEmpty()) {
                System.out.println(maximumValue);
            } else {
                System.out.println(ERROR_MESSAGE);
            }
        }
    }

    private static void addVertex(int vertex) {
        vertexes.remove((Object) vertex);
        graph.stream()
                .filter(edge -> edge.from == vertex && vertexes.stream().anyMatch(item -> item == edge.to))
                .forEach(edges::add);
    }

    private static void findMaximum() {
        addVertex(1);

        while (!vertexes.isEmpty() && !edges.isEmpty()) {
            var edge = edges.poll();
            if (vertexes.stream().anyMatch(item -> item == edge.to)) {
                maximumValue += edge.weight;
                addVertex(edge.to);
            }
        }
    }

    private static void readGraph(BufferedReader reader, int edgeCount) throws IOException {

        for (int i = 0; i < edgeCount; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            var u = Integer.parseInt(tokenizer.nextToken());
            var v = Integer.parseInt(tokenizer.nextToken());
            var w = Integer.parseInt(tokenizer.nextToken());

            graph.add(new Edge(u, v, w));
            graph.add(new Edge(v, u, w));
        }
    }

    private static void initVertexes(int vertexCount) {
        for (int i = 1; i <= vertexCount; i++) {
            vertexes.add(i);
        }
    }
}
