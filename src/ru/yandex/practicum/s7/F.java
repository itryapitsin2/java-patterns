package ru.yandex.practicum.s7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class F {

    private static final double modulo = Math.pow(10, 9) + 7;
    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            var line = reader.readLine().split(" ");
            var n = Integer.parseInt(line[0]);
            var k = Integer.parseInt(line[1]);
            var steps = new double[n];

            steps[0] = 1;

            for (int i = 1; i < n; i++) {
                double t = 0;
                var limit = Math.max(i - k, 0);
                for (int j = limit; j < i; j++) {
                    t += steps[j];
                }
                steps[i] = t % modulo;
            }

            System.out.printf("%d%n", (long) steps[steps.length - 1]);
        }
    }
}
