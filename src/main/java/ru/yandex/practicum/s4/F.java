package ru.yandex.practicum.s4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class F {
    public static long alphaPow(int a, long distance, int mod) {
        long m = Math.floorMod(a, mod);
        long t = 1;

        while (distance > 0) {
            if ((distance % 2) == 1) {
                t *= m;
                t = Math.floorMod(t, mod);
            }
            m *= m;
            m = Math.floorMod(m, mod);
            distance /= 2;
        }

        return Math.floorMod(t, mod);
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int a = scanner.nextInt();
            scanner.nextLine();
            int mod = scanner.nextInt();
            scanner.nextLine();

            String s = scanner.nextLine();
            int substringCount = scanner.nextInt();
            scanner.nextLine();
            List<int[]> substrings = readSubstrings(scanner, substringCount);

            long[] hashes = new long[s.length() + 1];
            hashes[0] = 0;
            hashes[1] = s.charAt(0) % mod;
            char[] chars = s.toCharArray();

            for (int i = 2; i <= chars.length; i++) {
                char c = chars[i-1];
                hashes[i] = (hashes[i - 1] * a + c) % mod;
            }

            for (int i = 0; i < substrings.size(); i++) {
                int start = substrings.get(i)[0];
                int end = substrings.get(i)[1];
                long t = Math.floorMod(
                        Math.floorMod(hashes[end], mod) - hashes[start - 1] * alphaPow(a, end - start + 1, mod),
                        mod
                );
                System.out.println(t);
            }
        }
    }

    private static List<int[]> readSubstrings(Scanner scanner, int substringCount) {
        List<int[]> result = new ArrayList<>();
        int i = 1;
        while (i <= substringCount) {
            String line = scanner.nextLine();
            String[] indexes = line.split(" ");

            result.add(new int[]{Integer.parseInt(indexes[0]), Integer.parseInt(indexes[1])});
            i++;
        }

        return result;
    }
}
