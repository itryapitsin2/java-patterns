package ru.yandex.practicum.s4;

import java.util.*;
import java.util.stream.Collectors;

public class G {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            scanner.nextLine();

            int S = scanner.nextInt();
            scanner.nextLine();

            String[] s = scanner.nextLine().split(" ");
            if (s.length <= 1) {
                System.out.println(0);
                return;
            }

            long[] mass = Arrays.stream(s).mapToLong(Long::parseLong).sorted().toArray();

            Map<Long, int[]> tmp = new TreeMap<>();

            for (int i = 0; i < mass.length; i++) {
                for (int j = i + 1; j < mass.length; j++) {
                    tmp.put(mass[i] + mass[j], new int[]{i, j});
                }
            }

            List<String> result = new ArrayList<>();

            for (int i = 0; i < mass.length; i++) {
                if (i > 0 && mass[i] == mass[i - 1]) {
                    continue;
                }
                for (int j = i + 1; j < mass.length; j++) {
                    if (j > i + 1 && mass[j] == mass[j - 1]) {
                        continue;
                    }

                    long sum = mass[i] + mass[j];

                    if (!tmp.containsKey(S - sum)) {
                        continue;
                    }

                    int[] pairs = tmp.get(S - sum);
                    if (pairs[0] <= j) {
                        continue;
                    }
                    List<Long> list = new ArrayList<>();
                    list.add(mass[pairs[0]]);
                    list.add(mass[pairs[1]]);
                    list.add(mass[i]);
                    list.add(mass[j]);
                    String collect = list.stream().sorted().map(String::valueOf).collect(Collectors.joining(" "));
                    result.add(collect);
                }
            }

            System.out.println(result.size());

            result.forEach(System.out::println);
        }
    }
}
