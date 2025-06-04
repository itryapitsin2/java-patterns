package ru.yandex.practicum.s3;

import jdk.jshell.spi.ExecutionControl;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E {
    public static void main(String[] args) throws ExecutionControl.NotImplementedException {
        try (Scanner scanner = new Scanner(System.in)) {
            String[] lines = scanner.nextLine().split(" ");
            int countOfHouse = Integer.parseInt(lines[0]);
            int budget = Integer.parseInt(lines[1]);

            List<Integer> ads = getAds(scanner);

            int suggestedHouses = findHouses(countOfHouse, budget, ads);

            System.out.println(suggestedHouses);
        }
    }

    private static int findHouses(int countOfHouse, int budget, List<Integer> ads) throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("");
    }

    public static List<Integer> getAds(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
    }
}
