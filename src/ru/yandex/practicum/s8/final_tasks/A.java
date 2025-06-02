package ru.yandex.practicum.s8.final_tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Объяснение решения сделано в файле README_A.md.
 * Ссылка на отчёт https://contest.yandex.ru/contest/26133/run-report/130333274/
 */
public class A {
    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            var count = Integer.parseInt(reader.readLine());
            var compressedPrefix = reader.readLine();
            var prefix = getUnpackedString(compressedPrefix);

            for (int i = 0; i < count - 1; i++) {
                var nextPrefix = getUnpackedString(reader.readLine().trim());
                prefix = findMaxPrefix(prefix, nextPrefix);
            }

            System.out.println(prefix);
        }
    }

    private static String findMaxPrefix(String s1, String s2) {
        var result = s1;
        while (s2.indexOf(result) != 0) {
            result = result.substring(0, result.length() - 1);
        }
        return result;
    }

    private static String getUnpackedString(String s) {
        var stack = new Stack<String>();
        for (char charAt : s.toCharArray()) {
            if (charAt == ']') {
                var data = new ArrayList<String>();
                while (true) {
                    String stackChar = stack.pop();
                    if (stackChar.equals("[")) {
                        break;
                    }
                    data.add(stackChar);
                }
                var count = Integer.parseInt(stack.pop());
                var sb = new StringBuilder();
                for (String str : data) {
                    sb.append(str);
                }
                stack.push(sb.toString().repeat(count));
            } else {
                stack.push(String.valueOf(charAt));
            }
        }
        var result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.reverse().toString();
    }
}
