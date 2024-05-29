package problems.easy.FindTargetIndicesAfterSortingArray;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<Integer> targetIndices(int[] nums, int target) {
        // Idea of the method: find count of fewer elements and count of targets
        int equalCount = 0, lessCount = 0;
        for (int n : nums) {
            if (n == target) equalCount++;
            if (n < target) lessCount++;
        }

        // Now, push index next after less element.
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < equalCount; i++) {
            result.add(lessCount++);
        }
        return result;
    }
}
