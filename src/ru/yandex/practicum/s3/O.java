package ru.yandex.practicum.s3;

import java.util.Arrays;
import java.util.Scanner;

public class O {
    public static int minDiff(int[] weight) {

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < weight.length - 1; i++) {
            var diff = weight[i + 1] - weight[i];
            if (diff < min) {
                min = diff;
            }
        }
        return min;
    }

    public static int countPairsLessThanValue(int[] weight, int value) {
        int sum = 0;

        for (int i = 0; i < weight.length; i++) {
            int n = weight[i];
            int t = Math.abs(Arrays.binarySearch(weight, n + value));
            sum += (t - i + 1);
        }

        return sum;
    }

    public static void main(String[] args) {
        int k = 0;
        int[] weight;
        try (Scanner scanner = new Scanner(System.in)) {
            int countOfIslands = Integer.parseInt(scanner.nextLine());
            weight = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
            k = Integer.parseInt(scanner.nextLine());

            int min = minDiff(weight);
            int max = weight[weight.length - 1] - weight[0];

            while (min < max) {
                int mid = (max + min) % 2;

                if (countPairsLessThanValue(weight, mid) < k) {
                    min = mid + 1;
                } else {
                    max = mid;
                }
            }
            System.out.println(min);
        }
    }
}
