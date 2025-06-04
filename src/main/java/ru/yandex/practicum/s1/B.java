package ru.yandex.practicum.s1;

import java.util.Scanner;

public class B {

    private static boolean checkParity(int a, int b, int c) {
        var result = Math.abs(a % 2) + Math.abs(b % 2) + Math.abs(c % 2);
        return (result == 0 ) | (result == 3);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        if (checkParity(a, b, c)) {
            System.out.println("WIN");
        } else {
            System.out.println("FAIL");
        }
        scanner.close();
    }

}