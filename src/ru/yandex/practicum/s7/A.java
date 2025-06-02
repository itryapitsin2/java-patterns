package ru.yandex.practicum.s7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class A {
    public static void main(String[] args) throws IOException {

        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            var countOfDays = Integer.parseInt(reader.readLine());

            var prices = new ArrayList<>(Arrays
                    .stream(reader.readLine().split(" "))
                    .map(Integer::parseInt)
                    .toList());

            var sum = 0;

            for (var i = 0; i < countOfDays; i++) {
                if (i < prices.size() - 1 && prices.get(i) < prices.get(i + 1)) {
                    sum += prices.get(i + 1) - prices.get(i);
                }
            }

            System.out.println(sum);
        }
    }
}
