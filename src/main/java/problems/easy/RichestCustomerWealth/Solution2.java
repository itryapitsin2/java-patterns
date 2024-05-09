package problems.easy.RichestCustomerWealth;

public class Solution2 {

    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for(int[] man : accounts ) {
            int currentSum = 0;
            for(int bank : man) {
                currentSum = currentSum + bank;
            }
            max = Math.max(max,currentSum);
        }
        System.gc();
        return max;
    }
}