package ru.yandex.practicum.s8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class L {
    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            var s = reader.readLine().toCharArray();
            var p = new int[s.length];
            p[0] = 0;
            for (int i = 1; i < s.length; i++) {
                var k = p[i - 1];
                while (k > 0 && s[k] != s[i]) {
                    k = p[k - 1];
                }
                if (s[k] == s[i]) {
                    k++;
                }
                p[i] = k;
            }

            System.out.print(Arrays.stream(p).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
        }
    }
}
