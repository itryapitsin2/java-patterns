package problems.easy.FindTargetIndicesAfterSortingArray;

public class Main {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.printf("Solution1:  " + solution1.targetIndices(new int[] {1,2,5,2,3}, 2) + "\n");
        System.out.printf("Solution1:  " + solution1.targetIndices(new int[] {1,2,5,2,3}, 3) + "\n");

        Solution2 solution2 = new Solution2();
        System.out.printf("Solution2:  " + solution2.targetIndices(new int[] {1,2,5,2,3}, 2) + "\n");
        System.out.printf("Solution2:  " + solution2.targetIndices(new int[] {1,2,5,2,3}, 3) + "\n");
    }
}