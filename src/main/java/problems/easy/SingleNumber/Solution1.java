package problems.easy.SingleNumber;

public class Solution1 {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        System.gc();
        return result;
    }
}