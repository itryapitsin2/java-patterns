package problems.easy.CountPairsWhoseSumIsLessThanTarget;

import java.util.Collections;
import java.util.List;

public class Solution2 {
    public int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);
        int count = 0;
        int left = 0;
        int right = nums.size() - 1;
        while (left < right) {
            int sum = nums.get(left) + nums.get(right);
            if (sum < target) {
                count += right - left;
                left++;
            } else {
                right--;
            }
        }
        return count;
    }
}