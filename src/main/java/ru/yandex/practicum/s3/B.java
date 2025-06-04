package ru.yandex.practicum.s3;

import java.util.Scanner;

public class B {

    private static final String[][] KEYBOARD = new String[][]{
            {},
            {},
            {"a", "b", "c"},
            {"d", "e", "f"},
            {"g", "h", "i"},
            {"j", "k", "l"},
            {"m", "n", "o"},
            {"p", "q", "r", "s"},
            {"t", "u", "v"},
            {"w", "x", "y", "z"}
    };

    public static void getWords(char[] keys, int deep, String prefix) {
        if (keys.length - deep == 0) {
            System.out.print(prefix + " ");
        } else {

            int key = Character.getNumericValue(keys[deep]);
            for (String symbol : KEYBOARD[key]) {
                getWords(keys, deep + 1, prefix + symbol);
            }
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            char[] keys = scanner.nextLine().toCharArray();
            getWords(keys, 0, "");
        }
    }
}
