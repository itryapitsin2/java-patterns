package ru.yandex.practicum.s3;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class D {
    public static int childSatisfaction(List<Integer> factorOfGreed, List<Integer> cookieSize) {
        var sortedChildren = factorOfGreed.stream().sorted().collect(Collectors.toList());
        var sortedCookies = cookieSize.stream().sorted().collect(Collectors.toList());
        int result = 0;
        int idx = 0;
        for (int i = 0; i < sortedChildren.size(); i++) {
            for (int j = idx; j < sortedCookies.size(); j++) {
                var factor = sortedChildren.get(i);
                var size = sortedCookies.get(j);

                if (factor <= size) {
                    result++;
                    idx = j + 1;
                    break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {
            int countOfChild = Integer.parseInt(scanner.nextLine());
            List<Integer> factorOfGreed = Arrays.stream(scanner.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            int countOfCookies = Integer.parseInt(scanner.nextLine());
            List<Integer> cookieSize = Arrays.stream(scanner.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            System.out.println(childSatisfaction(factorOfGreed, cookieSize));
        }
    }
}
