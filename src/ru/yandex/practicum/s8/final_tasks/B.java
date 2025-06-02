package ru.yandex.practicum.s8.final_tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Объяснение решения сделано в файле README_И.md.
 * Ссылка на отчёт https://contest.yandex.ru/contest/26133/run-report/130334581/
 */
public class B {

    public static final String YES = "YES";
    public static final String NO = "NO";

    static class Node {
        Map<Character, Node> edges = new HashMap<>();
        boolean isTerminal = false;
    }

    private static String text;
    private static List<String> patterns;

    private static Node createPrefixTree() {
        var root = new Node();
        for (var pattern : patterns) {
            var node = root;
            for (var character : pattern.toCharArray()) {
                var nextNode = node.edges.getOrDefault(character, new Node());
                node.edges.put(character, nextNode);
                node = nextNode;
            }
            node.isTerminal = true;
        }
        return root;
    }

    public static boolean canBeSplit() {
        var root = createPrefixTree();
        var textLength = text.length();
        var dp = new boolean[textLength + 1];
        dp[0] = true;

        for (var i = 0; i < textLength; i++) {
            var node = root;
            if (dp[textLength]) {
                return true;
            }
            if (dp[i]) {
                for (var j = i; j <= textLength; j++) {
                    if (node.isTerminal) {
                        dp[j] = true;
                    }
                    if (j == textLength || !node.edges.containsKey(text.charAt(j))) {
                        break;
                    }
                    node = node.edges.get(text.charAt(j));
                }
            }
        }
        return dp[textLength];
    }

    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            text = reader.readLine();
            var patternCount = Integer.parseInt(reader.readLine());
            patterns = new ArrayList<>();

            for (int i = 0; i < patternCount; i++) {
                patterns.add(reader.readLine().trim());
            }

            var result = canBeSplit();
            System.out.println(result ? YES : NO);
        }
    }
}