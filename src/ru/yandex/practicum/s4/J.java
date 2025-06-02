package ru.yandex.practicum.s4;

import java.util.*;

public class J {


    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            scanner.nextLine();
            int[] first = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int m = scanner.nextInt();
            scanner.nextLine();
            int[] second = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            LinkedHashMap<Integer, Integer> matches = new LinkedHashMap<>();
            for (int i = 0; i < first.length; i++) {
                for (int j = 0; j < second.length; j++) {
                    if (first[i] == second[j]) {
                        matches.putFirst(i, j);
                    }
                }
            }


        }
    }
}
