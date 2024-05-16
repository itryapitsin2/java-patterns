package org.examples;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    @Test
    public void countPairs() {
        List<Integer> nums = Arrays.asList(-6,2,5,-2,-7,-1,3);
        int target = -2;
        // for(int i = 0; i < nums.size(); i++) {
        //     for(int j = i + 1; j < nums.size(); j++) {
        //         if (nums.get(i) + nums.get(j) < target) {
        //             result++;
        //         }
        //     }
        // }
        Collections.sort(nums);

        int first = 0;
        int last = nums.size() - 1;
        int middle = 0;
        int firstVal = nums.get(first);
        while(first <= last) {
            middle = first + ((last - first) / 2);
            int val = nums.get(middle) + firstVal;
            if (val == target) {
                break;
            } else if (val > target) {
                last = middle - 1;
            } else {
                first = middle + 1;
            }
        }

        // System.gc();
        int t = middle;
    }
}
