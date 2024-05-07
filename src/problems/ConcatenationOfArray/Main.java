package problems.ConcatenationOfArray;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.printf("Solution1: [1,2,1] is " + Arrays.toString(solution1.getConcatenation(new int[]{1, 2, 1})) + "\n");
        System.out.printf("Solution1: [1,3,2,1] is " + Arrays.toString(solution1.getConcatenation(new int[]{1, 3, 2, 1})) + "\n");
    }
}