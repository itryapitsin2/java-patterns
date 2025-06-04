package ru.yandex.practicum.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class L {
    public static int calCommits(int n, int k) {
        if (n < 2) {
            return 1;
        }

        int prev = 1;
        int cur = 1;
        for (int i = 2; i <= n; i++) {
            int tmp = cur;
            cur = (cur + prev) % (int)Math.pow(10, k);
            prev = tmp;
        }
        return cur;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int[] numbers = readInt(reader);
            int commits = calCommits(numbers[0], numbers[1]);
            System.out.println(commits);
        }
    }

    private static int[] readInt(BufferedReader reader) throws IOException {
        String[] numbers = reader.readLine().split(" ");
        return new int[]{Integer.parseInt(numbers[0]), Integer.parseInt(numbers[1])};
    }
}
