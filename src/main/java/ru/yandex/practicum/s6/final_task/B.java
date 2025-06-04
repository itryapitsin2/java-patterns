package ru.yandex.practicum.s6.final_task;

import java.util.*;

/**
 * Объяснение решения сделано в файле README_И.md.
 * Ссылка на отчёт https://contest.yandex.ru/contest/25070/run-report/118864844/
 */
public class B {

    private enum Color {
        WHITE,
        GREY,
        BLACK
    }

    public static final String YES = "YES";
    public static final String NO = "NO";
    private static List<List<Integer>> graph = new ArrayList<>();
    private static Color[] colors;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            var countOfCities = Integer.parseInt(scanner.nextLine());

            readMap(scanner, countOfCities);

            if (isOptimal()) {
                System.out.println(YES);
            } else {
                System.out.println(NO);
            }
        }
    }

    private static boolean isOptimal() {

        for (int vertex = 0; vertex < graph.size(); vertex++) {
            if (hasCycle(vertex)) {
                return false;
            }
        }

        return true;
    }

    private static boolean hasCycle(int starVertex) {
        var stack = new Stack<Integer>();
        stack.add(starVertex);
        while (!stack.isEmpty()) {
            var vertex = stack.pop();
            if (colors[vertex] == Color.WHITE) {
                colors[vertex] = Color.GREY;
                stack.add(vertex);

                for (var destination : graph.get(vertex)) {
                    if (colors[destination] == Color.WHITE) {
                        stack.add(destination);
                    } else if (colors[destination] == Color.GREY) {
                        return true;
                    }
                }
            } else if (colors[vertex] == Color.GREY) {
                colors[vertex] = Color.BLACK;
            }
        }

        return false;
    }

    private static void readMap(Scanner scanner, int countOfCities) {
        colors = new Color[countOfCities];

        for (int i = 0; i < countOfCities; i++) {
            colors[i] = Color.WHITE;
        }

        for (int i = 0; i < countOfCities; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < countOfCities - 1; i++) {
            var roads = scanner.nextLine().toCharArray();
            for (int j = 0; j < roads.length; j++) {
                var road = roads[j];
                var target = i + j + 1;
                if (road == 'R') {
                    graph.get(i).add(target);
                } else {
                    graph.get(target).add(i);
                }
            }
        }
    }
}
