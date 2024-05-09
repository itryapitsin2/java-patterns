package problems.easy.NumberOfGoodPairs;

public class Main {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.printf("Solution1: nums = [1,2,3,1,1,3] is " + solution1.numIdenticalPairs(new int[] {1,2,3,1,1,3}) + "\n");
        System.out.printf("Solution1: nums = [1,1,1,1] is " + solution1.numIdenticalPairs(new int[] {1,1,1,1}) + "\n");

        Solution2 solution2 = new Solution2();
        System.out.printf("Solution2: nums = [1,2,3,1,1,3] is " + solution2.numIdenticalPairs(new int[] {1,2,3,1,1,3}) + "\n");
        System.out.printf("Solution2: nums = [1,1,1,1] is " + solution2.numIdenticalPairs(new int[] {1,1,1,1}) + "\n");
    }
}