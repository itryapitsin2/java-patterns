package problems.easy.NumberOfGoodPairs;

public class Solution2 {
    public int numIdenticalPairs(int[] nums) {
        return helper(nums, 0, 0);
    }

    public int helper(int[] nums, int i, int count) {
        if (i == nums.length) {
            return count;
        }
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[i] == nums[j]) {count++;}
        }
        return helper(nums, ++i, count);
    }
}
