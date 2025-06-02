package ru.yandex.practicum.s4;

import java.util.Scanner;

public class D {
    public static long getHash(int a, int mod, String s) {
        if (s.isEmpty()) {
            return 0;
        }

        if (s.length() == 1) {
            return s.charAt(0);
        }

        char[] chars = s.toCharArray();
        long hash = ((long) chars[0] * a + chars[1]) % mod;

        for (int i = 2; i < chars.length; i++) {
            char c = chars[i];
            hash = (hash * a + c) % mod;
        }

        return hash;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int a = scanner.nextInt();
            scanner.nextLine();

            int mod = scanner.nextInt();
            scanner.nextLine();

            String s = scanner.nextLine();

            long hash = getHash(a, mod, s);

            System.out.println(hash);
        }
    }
}