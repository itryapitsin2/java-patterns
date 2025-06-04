package ru.yandex.practicum.s4;

import java.util.*;

public class B {
    private static int sum(int[] rounds, int from, int to) {
        int result = 0;
        for (int i = from; i <= to; i++) {
            int round = rounds[i];
            if (round == 0) {
                result++;
            } else {
                result--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            scanner.nextLine();

            String[] s = scanner.nextLine().split(" ");
            if (s.length == 0 || s.length == 1) {
                System.out.println(0);
                return;
            }

            int[] rounds = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();

            Map<Integer, Integer> map = new LinkedHashMap<>();

            int b = 0;
            int max = 0;
            map.put(b, -1);
            for (int i = 0; i < rounds.length; i++) {
                int value = rounds[i];
                if (value == 1) {
                    b++;
                } else {
                    b--;
                }

                if (map.containsKey(b)) {
                    int distance = i - map.get(b);
                    if (distance > max) {
                        max = distance;
                    }
                } else {
                    map.put(b, i);
                }
            }

            System.out.println(max);
        }
    }
}
