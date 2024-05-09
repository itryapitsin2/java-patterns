package problems.easy.BuildArrayFromPermutation;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.printf("Solution1: nums = [0,2,1,5,3,4] is " + Arrays.toString(solution1.buildArray(new int[] {0,2,1,5,3,4})) + "\n");
        System.out.printf("Solution1: nums = [5,0,1,2,3,4] is " + Arrays.toString(solution1.buildArray(new int[] {5,0,1,2,3,4})) + "\n");

        Solution2 solution2 = new Solution2();
        System.out.printf("Solution2: nums = [0,2,1,5,3,4] is " + Arrays.toString(solution2.buildArray(new int[] {0,2,1,5,3,4})) + "\n");
        System.out.printf("Solution2: nums = [5,0,1,2,3,4] is " + Arrays.toString(solution2.buildArray(new int[] {5,0,1,2,3,4})) + "\n");
    }
}