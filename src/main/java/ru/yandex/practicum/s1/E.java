package ru.yandex.practicum.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class E {

    private static String getLongestWord(String text) {
        var tokenizer = new StringTokenizer(text);
        var longestWord = "";
        while (tokenizer.hasMoreTokens()) {
            var word = tokenizer.nextToken();
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        return longestWord;
    }
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int textLength = readInt(reader);
            String text = reader.readLine();
            String longestWord = getLongestWord(text);
            System.out.println(longestWord);
            System.out.println(longestWord.length());
        }

    }

    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

}