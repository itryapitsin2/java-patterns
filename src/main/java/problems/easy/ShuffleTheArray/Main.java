package problems.easy.ShuffleTheArray;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.printf("Solution1: nums = [2,5,1,3,4,7], n = 3 is " + Arrays.toString(solution1.shuffle(new int[] {2,5,1,3,4,7}, 3)) + "\n");
        System.out.printf("Solution1: nums = [1,2,3,4,4,3,2,1], n = 4 is " + Arrays.toString(solution1.shuffle(new int[] {1,2,3,4,4,3,2,1}, 4)) + "\n");

        Solution2 solution2 = new Solution2();
        System.out.printf("Solution2: nums = [2,5,1,3,4,7], n = 3 is " + Arrays.toString(solution2.shuffle(new int[] {2,5,1,3,4,7}, 3)) + "\n");
        System.out.printf("Solution2: nums = [1,2,3,4,4,3,2,1], n = 4 is " + Arrays.toString(solution2.shuffle(new int[] {1,2,3,4,4,3,2,1}, 4)) + "\n");

    }
}