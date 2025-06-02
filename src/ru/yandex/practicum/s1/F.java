package ru.yandex.practicum.s1;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;

public class F {

    private static boolean isPalindrome(String text) {
        text = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase(Locale.ROOT);

        for (int i = 0; i < text.length() / 2; i++) {
            var temp = text.charAt(i);
            var temp2 = text.charAt(text.length() - i - 1);
            if (temp != temp2) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException{
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String text = reader.readLine();
            if (isPalindrome(text)) {
                System.out.println("True");
            } else {
                System.out.println("False");
            }
        }
    }
}