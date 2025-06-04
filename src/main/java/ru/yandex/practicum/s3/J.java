package ru.yandex.practicum.s3;

import java.util.Arrays;
import java.util.Scanner;

import static java.util.stream.Collectors.joining;

public class J {
    public static void bubbleSort(int[] numbers) {
        boolean flag = true;
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 0; j < numbers.length - i - 1; j++) {
                int a = numbers[j];
                int b = numbers[j + 1];
                if (a > b) {
                    numbers[j] = b;
                    numbers[j + 1] = a;
                    flag = true;
                }
            }

            if (flag) {
                String result = Arrays
                        .stream(numbers)
                        .mapToObj(String::valueOf)
                        .collect(joining(" ", "", ""));
                System.out.println(result);
                flag = false;
            }
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int length = Integer.parseInt(scanner.nextLine());
            int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            bubbleSort(numbers);
        }
    }
}
