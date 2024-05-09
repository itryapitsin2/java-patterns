package problems.RichestCustomerWealth;

public class Solution1 {

    public int maximumWealth(int[][] accounts) {
        int result = 0;
        for(int i = 0; i < accounts.length; i++) {
            int money = 0;
            for(int j = 0; j < accounts[i].length; j++) {
                money += accounts[i][j];
            }
            if (money > result) {
                result = money;
            }
        }

        System.gc();

        return result;
    }
}
