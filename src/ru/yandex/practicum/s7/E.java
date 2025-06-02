package ru.yandex.practicum.s7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class E {
    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            var x = Integer.parseInt(reader.readLine());
            var k = Integer.parseInt(reader.readLine());
            List<Integer> coins = Arrays.stream(reader.readLine().split(" "))
                    .map(Integer::parseInt)
                    .sorted((x1, x2) -> Integer.compare(x2, x1))
                    .toList();
        }
    }
}
