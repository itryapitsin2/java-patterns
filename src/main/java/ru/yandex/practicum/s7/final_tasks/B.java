package ru.yandex.practicum.s7.final_tasks;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://contest.yandex.ru/contest/25597/problems/B/?success=122710669#2989/2020_04_29/zDij5o2YCE
 */
public class B {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            var n = Integer.parseInt(scanner.nextLine());
            var parties = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            var K = Arrays.stream(parties).sum();

            if (K % 2 != 0) {
                System.out.println("False");
                return;
            }

            var dp = new boolean[(K / 2) + 1];
            dp[0] = true;

            for (int party : parties) {
                for (int j = K / 2; j >= party; j--) {
                    if ((j - party) >= 0) {
                        dp[j] = dp[j - 1] || dp[j - party];
                    } else {
                        dp[j] = dp[j - 1];
                    }
                }
            }

            System.out.println(dp[dp.length - 1] ? "True" : "False");
        }
    }
}
