package ru.yandex.practicum.s8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class С {

    private static final int SHIFT = 97;

    public static void main(String[] args) throws IOException {

        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {

            var str = reader.readLine().toCharArray();
            var alphabet = new int[26];
            for (var c : str) {
                var idx = (int)c - SHIFT;
                var value = alphabet[idx];
                value++;
                alphabet[idx] = value;
            }

            var result = new StringBuffer();

            for (int i = 0; i < alphabet.length; i++) {
                var count = alphabet[i];
//                if (count % 2 != 0) {
//                    count--;
//                }

                for (int j = 0; j < count / 2; j++) {
                    result.append((char)(i + SHIFT));
                }
            }

            System.out.println("");
        }
    }
}
