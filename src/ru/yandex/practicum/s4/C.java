package ru.yandex.practicum.s4;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class C {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String first = scanner.nextLine();
            String second = scanner.nextLine();

            if (first.length() != second.length()) {
                System.out.println("NO");
                return;
            }

            boolean result = checkLines(first, second);

            System.out.println(result ? "YES" : "NO");
        }
    }

    private static boolean checkLines(String first, String second) {
        Hashtable<Character, Integer> firstHashtable = createHashtable(first);
        Hashtable<Character, Integer> secondHashtable = createHashtable(second);

        AtomicBoolean hasEquals = new AtomicBoolean(true);
        firstHashtable.forEach((key1, value1) -> {
            hasEquals.set(hasEquals.get() & secondHashtable.containsValue(value1));
        });

        return hasEquals.get();
    }

    public static Hashtable<Character, Integer> createHashtable(String s) {
        Hashtable<Character, Integer> hashtable = new Hashtable<>();
        char[] charArray = s.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            var value = hashtable.get(c);
            if (value == null) {
                value = 0;
            }
            value += i;
            hashtable.put(c, value);
        }

        return hashtable;
    }
}
