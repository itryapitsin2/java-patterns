package ru.yandex.practicum.s3;

import java.util.*;
import java.util.stream.Collectors;

public class N {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int length = scanner.nextInt();
            scanner.nextLine();

            List<List<Integer>> flowerBeds = readFlowerBeds(scanner, length);
            flowerBeds = calculateFlowerBeds(flowerBeds);

            flowerBeds.forEach(x ->
                    System.out.println(x.stream()
                            .map(Object::toString)
                            .collect(Collectors.joining(" "))
                    )
            );

        }
    }

    public static List<List<Integer>> calculateFlowerBeds(List<List<Integer>> flowerBeds) {
        flowerBeds = sort(flowerBeds);
        var result = new ArrayList<List<Integer>>();

        List<Integer> current = new ArrayList<>();
        for (List<Integer> flowerBed : flowerBeds) {
            if (result.isEmpty()) {
                current = flowerBed;
                result.add(current);
            } else if (flowerBed.get(0) <= current.get(1) && current.get(1) < flowerBed.get(1)) {
                current.set(1, flowerBed.get(1));
            } else if (current.get(1) < flowerBed.get(0) || current.get(1) < flowerBed.get(1)) {
                current = new ArrayList<>(flowerBed);
                result.add(current);
            }
        }

        return result;
    }

    public static List<List<Integer>> sort(List<List<Integer>> flowerBeds) {
        if (flowerBeds.size() == 1) {
            return flowerBeds;
        }

        var left = sort(flowerBeds.subList(0, flowerBeds.size() / 2));
        var right = sort(flowerBeds.subList(flowerBeds.size() / 2, flowerBeds.size()));

        var result = new ArrayList<List<Integer>>();
        int l = 0, r = 0;

        while (l < left.size() && r < right.size()) {
            if (left.get(l).get(0) <= right.get(r).get(0)) {
                result.add(left.get(l));
                l++;
            } else {
                result.add(right.get(r));
                r++;
            }
        }

        while (l < left.size()) {
            result.add(left.get(l));
            l++;
        }

        while (r < right.size()) {
            result.add(right.get(r));
            r++;
        }

        return result;
    }

    public static List<List<Integer>> readFlowerBeds(Scanner scanner, int length) {
        List<List<Integer>> flowerBeds = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            List<Integer> flowerBed = Arrays.stream(scanner.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            flowerBeds.add(flowerBed);
        }

        return flowerBeds;
    }
}
