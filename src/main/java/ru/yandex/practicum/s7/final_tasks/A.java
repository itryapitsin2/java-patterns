package ru.yandex.practicum.s7.final_tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {
    public static void main(String[] args) throws IOException {

        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            var str1 = reader.readLine();
            var str2 = reader.readLine();

            var n = str1.length() + 1;
            var m = str2.length() + 1;

            var dp = new int[n][m];

            for (var i = 0; i < n; i++) {
                var s1 = str1.charAt(i);
                for (int j = 0; j < m; j++) {
                    var s2 = str2.charAt(j);
                    if (s1 == s2) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    } else {

                    }
                }
            }
        }
    }
}
