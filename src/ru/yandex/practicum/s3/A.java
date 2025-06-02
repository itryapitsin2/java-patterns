package ru.yandex.practicum.s3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A {
    private static final String LEFT_BRACKET = "(";
    private static final String RIGHT_BRACKET = ")";
    private static final List<String> brackets = new ArrayList<>();

    /**
     *
     * @param prefix Префик
     * @param unique Счётчик открытых скобок
     * @param left Левая скобка
     * @param right Правая скобка
     */
    public static void generateBrackets(String prefix, int unique, int left, int right) {
        if (left == 0 && right == 0) {
            brackets.add(prefix);
        } else {
            if (left > 0) {
                generateBrackets(prefix + LEFT_BRACKET, unique + 1, left - 1, right);
            }
            if (unique > 0 && right > 0) {
                generateBrackets(prefix + RIGHT_BRACKET, unique - 1, left, right - 1);
            }
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int control = 0;
            generateBrackets("", control, n, n);
            brackets.forEach(System.out::println);
        }
    }
}
