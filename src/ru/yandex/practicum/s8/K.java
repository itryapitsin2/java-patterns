package ru.yandex.practicum.s8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class K {
    public static void main(String[] args) throws IOException {

        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {

            var charArray = reader.readLine().toCharArray();
            var first = new StringBuilder();
            char[] finalCharArray = charArray;
            IntStream.range(0, charArray.length).forEach(i -> {
                var s = finalCharArray[i];
                if (s % 2 == 0) {
                    first.append(s);
                }
            });

            charArray = reader.readLine().toCharArray();
            var second = new StringBuilder();
            char[] finalCharArray1 = charArray;
            IntStream.range(0, charArray.length).forEach(i -> {
                var s = finalCharArray1[i];
                if (s % 2 == 0) {
                    second.append(s);
                }
            });
            var result = first.toString().compareTo(second.toString());
            System.out.println(Integer.compare(result, 0));
        }
    }
}
