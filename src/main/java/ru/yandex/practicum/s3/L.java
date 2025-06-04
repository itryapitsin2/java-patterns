package ru.yandex.practicum.s3;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class L {

    private static class Binary {
        static int findDay(List<Integer> values, int left, int right, int price) {
            if (left > right) {
                return -1;
            }

            if (left == right && values.get(left) >= price) {
                return right + 1;
            }

            int mid = (left + right) / 2;
            int midValue = values.get(mid);
            int leftValue = mid > 0 ? values.get(mid - 1) : 0;
            if (midValue >= price && leftValue < price) {
                return mid + 1;
            }

            if (price <= midValue) {
                return findDay(values, left, mid, price);
            } else {
                return findDay(values, mid + 1, right, price);
            }
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int days = sc.nextInt();
            sc.nextLine();
            List<Integer> values = readValues(sc, days);
            int cost = sc.nextInt();

            int first = L.Binary.findDay(values, 0, values.size() - 1, cost);
            int second = L.Binary.findDay(values, first, values.size() - 1, cost * 2);
            System.out.println(first + " " + second);
        }
    }

    public static List<Integer> readValues(Scanner sc, int days) {
        return Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
    }
}
