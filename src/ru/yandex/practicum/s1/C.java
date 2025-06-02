package ru.yandex.practicum.s1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;
import java.io.IOException;

public class C {

    private static List<Integer> getNeighbours(List<List<Integer>> matrix, int row, int col) {
        List<Integer> neighbours = new ArrayList<>();
        if (row > 0) {
            neighbours.add(matrix.get(row - 1).get(col));
        }

        if (row < matrix.size() - 1) {
            neighbours.add(matrix.get(row + 1).get(col));
        }

        if (col > 0) {
            neighbours.add(matrix.get(row).get(col - 1));
        }

        if (col < matrix.get(row).size() - 1) {
            neighbours.add(matrix.get(row).get(col + 1));
        }

        return neighbours;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int rowsCount = readInt(reader);
            int colsCount = readInt(reader);
            List<List<Integer>> matrix = readMatrix(reader, rowsCount);
            int rowId = readInt(reader);
            int colId = readInt(reader);
            List<Integer> neighbours = getNeighbours(matrix, rowId, colId)
                    .stream()
                    .sorted(Comparator.naturalOrder())
                    .collect(Collectors.toList());
            for (int element : neighbours) {
                System.out.print(element + " ");
            }
        }
    }


    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    private static List<Integer> readList(BufferedReader reader) throws IOException {
        return Arrays.asList(reader.readLine().split(" "))
                .stream()
                .map(elem -> Integer.parseInt(elem))
                .collect(Collectors.toList());
    }

    private static List<List<Integer>> readMatrix(BufferedReader reader, int rowsCount) throws IOException {
        List<List<Integer>> matrix = new ArrayList<>(rowsCount);
        for (int i = 0; i < rowsCount; i++) {
            matrix.add(readList(reader));
        }
        return matrix;
    }
}