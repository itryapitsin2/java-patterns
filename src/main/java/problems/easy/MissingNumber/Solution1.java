package problems.easy.MissingNumber;

public class Solution1 {
    public int singleNumber(int[] nums) {
        int n = nums.length;
        int sa = 0;
        int sn = n * (n + 1) / 2;
        for (int num : nums) {
            sa += num;
        }
        System.gc();
        return sn - sa;
    }
}