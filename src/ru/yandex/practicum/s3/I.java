package ru.yandex.practicum.s3;

import java.util.*;
import java.util.stream.Collectors;

public class I {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int countOfStudents = Integer.parseInt(scanner.nextLine());
            int[] universities = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int k = Integer.parseInt(scanner.nextLine());
            Map<Integer, Integer> list = new HashMap<>();

            for (int id : universities) {
                if (list.containsKey(id)) {
                    list.compute(id, (key, value) -> value + 1);
                } else {
                    list.put(id, 1);
                }
            }

            var sorted = list
                    .entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .limit(k)
                    .map(x -> x.getKey().toString())
                    .collect(Collectors.joining(" "));

            System.out.println(sorted);
        }
    }
}
