package problems.easy.MissingNumber;

public class Solution2 {
    public int singleNumber(int[] nums) {
        int r = nums.length;

        for(int i = 0; i < nums.length; i++) {
            r = r ^ i ^ nums[i];
        }

        return r;
    }
}