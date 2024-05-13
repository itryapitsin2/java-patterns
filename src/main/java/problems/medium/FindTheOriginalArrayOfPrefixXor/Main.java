package problems.medium.FindTheOriginalArrayOfPrefixXor;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.printf("Solution1: " + Arrays.toString(solution1.findArray(new int[]{5, 2, 0, 3, 1})) + "\n");
        System.out.printf("Solution1: " + Arrays.toString(solution1.findArray(new int[]{13})) + "\n");

        Solution2 solution2 = new Solution2();
        System.out.printf("Solution2: " + Arrays.toString(solution2.findArray(new int[]{5, 2, 0, 3, 1})) + "\n");
        System.out.printf("Solution2: " + Arrays.toString(solution2.findArray(new int[]{13})) + "\n");

    }
}