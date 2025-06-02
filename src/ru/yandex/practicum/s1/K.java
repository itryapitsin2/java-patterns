package ru.yandex.practicum.s1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class K {

    private static List<Integer> getKList(int k) {
        List<Integer> list = new ArrayList<>();



        return list;
    }

    private static List<Integer> getSum(List<Integer> numberList, int k) {
        var accumulator = 0;
        var length = numberList.size() - 1;
        for (int i = 0; i < numberList.size(); i++) {
            int value = numberList.get(length - i) * (int)Math.pow(10, i);
            accumulator += value;
        }



        return numberList;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int numberLength = readInt(reader);
            List<Integer> numberList = readList(reader);
            int k = readInt(reader);
            List<Integer> sum = getSum(numberList, k);
            for (int elem : sum) {
                writer.write(elem + " ");
            }
        }
    }

    private static List<Integer> readList(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }
}