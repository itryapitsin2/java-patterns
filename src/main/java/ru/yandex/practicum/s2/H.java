package ru.yandex.practicum.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class H {
    static Stack<Character> stack;
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String bracketSeq = reader.readLine();
            stack = new Stack<>();
            String result = isCorrectBracketSeq(bracketSeq);
            System.out.println(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.gc();
    }

    private static String isCorrectBracketSeq(String bracketSeq) {
        for (int i = 0; i < bracketSeq.length(); i++) {
            char c = bracketSeq.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
                continue;
            }

            char p;
            try {
                p = stack.get(stack.size() - 1);}
            catch (IndexOutOfBoundsException e) {
                return "False";
            }

            if (c == ')' && p == '(') {
                stack.pop();
            } else if (c == ']' && p == '[') {
                stack.pop();
            } else if (c == '}' && p == '{') {
                stack.pop();
            } else {
                stack.push(c);
            }

        }

        return stack.isEmpty() ? "True" : "False";
    }
}
