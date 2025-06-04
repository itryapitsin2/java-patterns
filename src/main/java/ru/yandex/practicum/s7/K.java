package ru.yandex.practicum.s7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class K {
    public static void main(String[] args) throws IOException {

        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            var n = Integer.parseInt(reader.readLine());

            var a = Arrays
                    .stream(reader.readLine().split(" "))
                    .map(Integer::parseInt)
                    .toArray();

            var m = Integer.parseInt(reader.readLine());

            var b = Arrays
                    .stream(reader.readLine().split(" "))
                    .map(Integer::parseInt)
                    .toArray();

            var dp = new int[n + 1][m + 1];

            for (int i = 1; i <= a.length; i++) {
                for (int j = 1; j <= b.length; j++) {
                    if (((Integer) a[i - 1]).longValue() == ((Integer) b[j - 1]).longValue()) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }

            var answerA = new ArrayList<Integer>();
            var answerB = new ArrayList<Integer>();

            int i = n, j = m;
            while (dp[i][j] > 0) {
                if (((Integer) a[i - 1]).longValue() == ((Integer) b[j - 1]).longValue()) {
                    answerA.add(i);
                    answerB.add(j);
                    i--;
                    j--;
                } else {
                    if (dp[i][j] == dp[i-1][j]) {
                        i--;
                    } else {
                        j--;
                    }
                }
            }

            System.out.println(dp[n][m]);
            System.out.println(answerA.reversed().stream().map(String::valueOf).collect(Collectors.joining(" ")));
            System.out.println(answerB.reversed().stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }
    }
}
