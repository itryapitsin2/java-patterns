package ru.yandex.practicum.s8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class A {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            var words = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

            for (int i = 0; i < words.size() / 2; i++) {
                Collections.swap(words, i, words.size() - 1 - i);
            }

            var joiner = new StringJoiner(" ");
            words.forEach(joiner::add);

            System.out.println(joiner);
        }
    }
}
