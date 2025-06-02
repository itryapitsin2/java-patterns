package ru.yandex.practicum.s3;


import java.util.*;

public class C {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String first = scanner.nextLine();
            String second = scanner.nextLine();
            boolean result = false;

            int idx = 0;
            for (int i = 0; i < first.length(); i++) {
                char f = first.charAt(i);
                boolean tmp = false;
                for (int j = idx; j < second.length(); j++) {
                    char s = second.charAt(j);
                    if (f == s) {
                        tmp = true;
                        idx = j + 1;
                        break;
                    }
                }
                if (tmp) {
                    result = true;
                } else {
                    result = false;
                    break;
                }
            }

            System.out.println(result ? "True" : "False");
        }
    }
}
