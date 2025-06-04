package ru.yandex.practicum.s3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class F {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int count = Integer.parseInt(scanner.nextLine());
            List<Integer> segments = Arrays.stream(scanner.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .sorted(Comparator.reverseOrder())
                    .collect(Collectors.toList());
            for (int i = 0; i < segments.size() - 2; i++) {

                if (segments.get(i) < segments.get(i + 1) + segments.get(i + 2)) {
                    System.out.println(segments.get(i) + segments.get(i + 1) + segments.get(i + 2));
                    break;
                }
            }
        }
    }
}
