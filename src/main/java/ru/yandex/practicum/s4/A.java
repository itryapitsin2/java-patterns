package ru.yandex.practicum.s4;

import java.util.*;

public class A {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            scanner.nextLine();

            Map<Integer, String> hobbies = new LinkedHashMap<>();

            for (int i = 0; i < n; i++) {
                String hobby = scanner.nextLine();
                hobbies.put(hobby.hashCode(), hobby);
            }

            hobbies.forEach((key, value) -> {
                System.out.println(value);
            });
        }
    }
}
