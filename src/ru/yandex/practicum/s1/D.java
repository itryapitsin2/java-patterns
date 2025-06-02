package ru.yandex.practicum.s1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.List;
import java.io.IOException;


public class D {

    private static int getWeatherRandomness(List<Integer> temperatures) {
        int result = 0;

        for (int i = 0; i < temperatures.size(); i++) {
            var before = i > 0 ? temperatures.get(i - 1) : Integer.MIN_VALUE;
            var current = temperatures.get(i);
            var after = i < (temperatures.size() - 1) ? temperatures.get(i + 1) : Integer.MIN_VALUE;

            if (before < current && current > after) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int numberOfDays = readInt(reader);
            List<Integer> temperatures = readList(reader);
            int chaosNumber = getWeatherRandomness(temperatures);
            System.out.println(chaosNumber);
        }
    }

    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    private static List<Integer> readList(BufferedReader reader) throws IOException {
        return Arrays.asList(reader.readLine().split(" "))
                .stream()
                .map(elem -> Integer.parseInt(elem))
                .collect(Collectors.toList());
    }
}