package ru.yandex.practicum.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class A {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int rows = Integer.parseInt(reader.readLine());
            int cols = Integer.parseInt(reader.readLine());
            Integer[][] matrix = readMatrix(reader, rows, cols);
            printMatrix(matrix);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Integer[][] readMatrix(BufferedReader reader, int rows, int cols) throws IOException {
        Integer[][] matrix = new Integer[cols][rows];
        for(int i = 0; i < rows && reader.ready(); i++) {
            List<Integer> splitRow = Arrays.stream(reader.readLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            for(int j = 0; j < cols; j++) {
                matrix[j][i] = splitRow.get(j);
            }
        }
        return matrix;
    }

    public static void printMatrix(Integer[][] matrix) {
        for (Integer[] ints : matrix) {
            StringJoiner joiner = new StringJoiner(" ");
            Arrays.stream(ints).forEach((x) ->joiner.add(x.toString()));
            System.out.print(joiner + "\n");
        }
    }
}
