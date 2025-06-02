package ru.yandex.practicum.s1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class J {

    public static List<Integer> integerFactorization(int n) {
        List<Integer> result = new ArrayList<>();
        int divisor = 2;
        while (n > 1) {
            int o = n % divisor;
            if (o == 0) {
                result.add(divisor);
                n /= divisor;
            } else {
                divisor++;
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int number = readInt(reader);
            List<Integer> sum = integerFactorization(number);
            for (int elem : sum) {
                writer.write(elem + " ");
            }
        }
    }
    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }
}
