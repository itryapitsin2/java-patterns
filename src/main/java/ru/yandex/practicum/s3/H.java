package ru.yandex.practicum.s3;

import java.util.Comparator;
import java.util.Scanner;

public class H {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int count = Integer.parseInt(scanner.nextLine());
            String[] numbers = readNumbers(scanner);
            Comparator<String> comparator = H::compareNumbers;
            String result = getMaxNumber(numbers, comparator);
            System.out.println(result);
        }
    }

    static int compareNumbers(String n1, String n2) {
        return Integer.parseInt(n1 + n2) < Integer.parseInt(n2 + n1) ? -1 : 1;
    }

    public static String getMaxNumber(String[] numbers, Comparator<String> less) {
        for (int i = 0; i < numbers.length; i++) {
            String n = numbers[i];
            int j = i;
            while (j > 0 && less.compare(n, numbers[j - 1]) < 0) {
                numbers[j] = numbers[j - 1];
                j--;
            }
            numbers[j] = n;
        }

        StringBuilder result = new StringBuilder();
        for (int i = numbers.length - 1; i >=0; i--) {
            result.append(numbers[i]);
        }
        return result.toString();
    }

    public static String[] readNumbers(Scanner scanner) {
        return scanner.nextLine().split(" ");
    }
}