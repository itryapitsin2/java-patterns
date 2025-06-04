package ru.yandex.practicum.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class G {

    private static String getBinaryNumber(int n) {
        if (n == 0) return "0";
        int log2N = (int) (Math.log(n) / Math.log(2));
        StringBuilder result = new StringBuilder();
        int tmp = n;
        for (int i = 0; i <= log2N; i++) {
            result.append(tmp % 2);
            tmp /= 2;
        }

        return result.reverse().toString();
    }
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = readInt(reader);
            System.out.println(getBinaryNumber(n));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }
}
