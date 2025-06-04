package ru.yandex.practicum.s7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class L {
    public static void main(String[] args) throws IOException {

        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            var line = reader.readLine().split(" ");
            var n = Integer.parseInt(line[0]);
            var M = Integer.parseInt(line[1]) + 1;
            var weights = Arrays.stream(reader.readLine().split(" "))
                    .map(Integer::parseInt)
                    .sorted((x, y) -> Integer.compare(y, x))
                    .toList();

            var dp = new int[2][M];

            for (Integer weight : weights) {
                for (int j = 0; j < M; j++) {
                    if (j - weight >= 0) {
                        dp[1][j] = Math.max(dp[0][j], weight + dp[0][j - weight]);
                    }
                }
                dp[0] = Arrays.copyOf(dp[1], dp[1].length);
            }
            System.out.println(dp[1][M - 1]);
        }
    }
}
