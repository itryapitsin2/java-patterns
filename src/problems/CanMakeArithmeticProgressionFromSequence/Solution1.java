package problems.CanMakeArithmeticProgressionFromSequence;

import java.util.Arrays;

class Solution1 {
    public boolean canMakeArithmeticProgression(int[] arr) {
        if (arr.length == 2) {
            return true;
        }

        Arrays.sort(arr);

        int distance = getDistance(arr[0], arr[1]);

        for (int i = 1; i < arr.length - 1; i++) {
            int tmp = getDistance(arr[i], arr[i + 1]);
            if (tmp != distance) {
                return false;
            }
        }

        return true;
    }

    public int getDistance(int a, int b) {
        return a - b;
    }
}