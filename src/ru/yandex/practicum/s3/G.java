package ru.yandex.practicum.s3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class G {

    public static List<Integer> sortColors(List<Integer> colors) {
        int[] colorsCount = new int[3];
        for (Integer color : colors) {
            colorsCount[color] += 1;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < colorsCount.length; i++) {
            int count = colorsCount[i];
            for (int j = 0; j < count; j++) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int count = scanner.nextInt();
            if (count == 0) {
                return;
            }
            scanner.nextLine();
            List<Integer> colors = Arrays.stream(scanner.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            colors = sortColors(colors);
            String result = colors.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(" "));
            System.out.println(result);
        }
    }
}
