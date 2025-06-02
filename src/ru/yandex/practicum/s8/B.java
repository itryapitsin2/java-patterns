package ru.yandex.practicum.s8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {
    public static void main(String[] args) throws IOException {

        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            var first = reader.readLine();
            var second = reader.readLine();

            var errors = 0;
            var sameLength = first.length() == second.length();
            var longest = first.length() > second.length() ? first.toCharArray() : second.toCharArray();
            var shortest = first.length() > second.length() ? second.toCharArray() : first.toCharArray();
            for (int i = 0; i < shortest.length; i++) {
                var l = longest[i + (sameLength ? 0 : errors)];
                var s = shortest[i];
                if (l != s) {
                    errors++;
                }
                if (errors > 1) {
                    break;
                }
            }

            if (errors > 1) {
                System.out.println("FAIL");
            } else {
                System.out.println("OK");
            }
        }
    }
}
