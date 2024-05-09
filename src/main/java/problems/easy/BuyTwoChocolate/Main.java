package problems.easy.BuyTwoChocolate;

public class Main {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.printf("Solution1: prices = [2,12,93,52,91,86,81,1,79,64], money = 43 " + solution1.buyChoco(new int[] {2,12,93,52,91,86,81,1,79,64}, 43) + "\n");

        Solution2 solution2 = new Solution2();
        System.out.printf("Solution2: prices = [2,12,93,52,91,86,81,1,79,64], money = 43 " + solution2.buyChoco(new int[] {2,12,93,52,91,86,81,1,79,64}, 43) + "\n");
    }
}