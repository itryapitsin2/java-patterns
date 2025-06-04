package ru.yandex.practicum.s2.final_tasks;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * Объяснение решения сделано в файле README_B.md.
 * Ссылка на отчёт https://contest.yandex.ru/contest/22781/run-report/115663949/
 */
public class B {
    public static class PostfixNotation extends Stack<Integer> {
        /**
         * Сложение двух верхних значений в стеке
         */
        public void plus() {
            int firstOperand = pop();
            int secondOperand = pop();
            push(secondOperand + firstOperand);
        }

        /**
         * Вычитание двух верхних значений в стеке
         */
        public void minus() {
            int firstOperand = pop();
            int secondOperand = pop();
            push(secondOperand - firstOperand);
        }

        /**
         * Умножение двух верхних значений в стеке
         */
        public void multiply() {
            int firstOperand = pop();
            int secondOperand = pop();
            push(secondOperand * firstOperand);
        }

        /**
         * Деление двух верхних значений в стеке
         */
        public void divide() {
            int firstOperand = pop();
            int secondOperand = pop();
            push(Math.floorDiv(secondOperand, firstOperand));
        }
    }

    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {
            String expression = scanner.nextLine();
            String[] tokens = expression.split(" ");
            PostfixNotation postfixNotation = new PostfixNotation();
            Arrays.stream(tokens).forEach(token -> parseToken(token, postfixNotation));
            System.out.println(postfixNotation.pop());
        }
    }

    public static void parseToken(String token, PostfixNotation postfixNotation) {
        switch (token) {
            case "+":
                postfixNotation.plus();
                break;
            case "-":
                postfixNotation.minus();
                break;
            case "/":
                postfixNotation.divide();
                break;
            case "*":
                postfixNotation.multiply();
                break;
            default:
                postfixNotation.push(Integer.parseInt(token));
        }
    }
}
