package problems.RichestCustomerWealth;


public class Main {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.printf("Solution1: " + solution1.maximumWealth(new int[][]{
                new int[]{1, 2, 3},
                new int[]{3, 2, 1}
        }) + "\n");
        System.out.printf("Solution1: " + solution1.maximumWealth(new int[][]{
                new int[]{1, 5},
                new int[]{7, 3},
                new int[]{3, 5}
        }) + "\n");
        System.out.printf("Solution1: " + solution1.maximumWealth(new int[][]{
                new int[]{2, 8, 7},
                new int[]{7, 2, 3},
                new int[]{1, 9, 5}
        }) + "\n");

        Solution2 solution2 = new Solution2();
        System.out.printf("Solution2: " + solution2.maximumWealth(new int[][]{
                new int[]{1, 2, 3},
                new int[]{3, 2, 1}
        }) + "\n");
        System.out.printf("Solution2: " + solution2.maximumWealth(new int[][]{
                new int[]{1, 5},
                new int[]{7, 3},
                new int[]{3, 5}
        }) + "\n");
        System.out.printf("Solution2: " + solution2.maximumWealth(new int[][]{
                new int[]{2, 8, 7},
                new int[]{7, 2, 3},
                new int[]{1, 9, 5}
        }) + "\n");

    }
}