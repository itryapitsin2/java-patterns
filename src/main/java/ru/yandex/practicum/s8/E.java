package ru.yandex.practicum.s8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class E {

    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            var word = reader.readLine();
            var n = Integer.parseInt(reader.readLine());
            TreeSet<Map.Entry<Integer, String>> words = new TreeSet<>(Comparator.comparingInt(Map.Entry::getKey));
            var i = 0;
            while (i < n) {
                var tmp = reader.readLine().split(" ");
                var idx = Integer.parseInt(tmp[1]);
                words.add(new AbstractMap.SimpleEntry<>(idx, tmp[0]));
                i++;
            }


            var accumulator = 0;

            for (var entry : words) {

                System.out.print(word.substring(accumulator, entry.getKey()) + entry.getValue());
                accumulator = entry.getKey();
            }

            System.out.println(word.substring(accumulator));
        }
    }
}
