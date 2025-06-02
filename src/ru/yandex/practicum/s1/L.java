package ru.yandex.practicum.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class L {

    private static char getExcessiveLetter(String s, String t) {
        var tStringBuilder = new StringBuilder(t);
        for (int i = 0; i < s.length(); i++) {
            char s1 = s.charAt(i);
            int idx = t.indexOf(s1);
            if (idx != -1) {
                tStringBuilder.deleteCharAt(idx);
                t = tStringBuilder.toString();
            } else {
                return s1;
            }
        }
        return tStringBuilder.toString().charAt(0);
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String s = reader.readLine();
            String t = reader.readLine();
            System.out.println(getExcessiveLetter(s, t));
        }
    }
}