package problems.easy.BuyTwoChocolate;

public class Solution1 {
    public int buyChoco(int[] prices, int money) {
        int maxLeftOver = money - (prices[0] + prices[1]);

        for(int i = 0; i < prices.length; i++) {
            if (prices[i] > money) {
                continue;
            }
            int tmp1 = money - prices[i];

            for(int j = i + 1; j < prices.length; j++) {
                int tmp2 = tmp1 - prices[j];

                if (tmp2 > maxLeftOver) {
                    maxLeftOver = tmp2;
                }
            }
        }

        return maxLeftOver < 0 ? money : maxLeftOver;
    }
}
