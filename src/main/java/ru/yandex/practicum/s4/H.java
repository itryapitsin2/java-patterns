package ru.yandex.practicum.s4;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class H {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            String string = scanner.nextLine();
            int mod = (int) Math.pow(10, 5) + 8;
            int a = 26;

            int result = 0;
            LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();

            for (int i = 0; i < string.length(); i++) {
                Character c = string.charAt(i);
                if(!map.containsKey(c)) {
                    map.putLast(c, i);
                    continue;
                }
                result = Math.max(map.size(), result);

                for (Object x : map.keySet().toArray()) {
                    map.remove(x);
                    if (x == c) {
                        break;
                    }
                }
                map.put(c, i);
            }

            System.out.println(Math.max(map.size(), result));
        }
    }
}
