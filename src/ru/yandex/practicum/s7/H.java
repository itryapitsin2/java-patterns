package ru.yandex.practicum.s7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class H {
    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            var line = reader.readLine().split(" ");
            var n = Integer.parseInt(line[0]);
            var m = Integer.parseInt(line[1]);
            var points = new int[n][m];

            for (int i = 0; i < n; i++) {
                char[] charArray = reader.readLine().toCharArray();
                for (int k = 0; k < m; k++) {
                    points[i][k] = Character.getNumericValue(charArray[k]);
                }
            }

            Collections.reverse(Arrays.asList(points));

            var dp = new int[n+1][m+1];
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < m + 1; j++) {

                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + points[i-1][j-1];
                }
            }

            System.out.println(dp[n][m]);
        }
    }
}
