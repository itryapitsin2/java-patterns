package problems.easy.CountPairsWhoseSumIsLessThanTarget;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.printf("Solution1: " + solution1.countPairs(Arrays.asList(-6,2,5,-2,-7,-1,3), -2) + "\n");
        System.out.printf("Solution1: " + solution1.countPairs(Arrays.asList(-1,1,2,3,1), 2) + "\n");

        Solution2 solution2 = new Solution2();
        System.out.printf("Solution1: " + solution2.countPairs(Arrays.asList(-6,2,5,-2,-7,-1,3), -2) + "\n");
        System.out.printf("Solution1: " + solution2.countPairs(Arrays.asList(-1,1,2,3,1), 2) + "\n");
    }
}