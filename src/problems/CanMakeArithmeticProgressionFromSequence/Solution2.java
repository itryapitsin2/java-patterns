package problems.CanMakeArithmeticProgressionFromSequence;

public class Solution2 {
    public boolean canMakeArithmeticProgression(int[] arr) {
        if (arr.length <= 2) return true;

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for (int data : arr) {
            min = data < min ? data : min;
            max = data > max ? data : max;
        }

        if ((max - min) % (arr.length - 1) != 0) return false;

        int d = (max - min) / (arr.length - 1);

        int i = 0;
        while (i < arr.length) {
            if (arr[i] == min + i * d) i++;
            else if ((arr[i] - min) % d != 0) return false;
            else {
                int pos = (arr[i] - min) / d;
                if (arr[pos] == arr[i]) return false;
                arr[i] = (arr[i] + arr[pos]) - (arr[pos] = arr[i]);
            }
        }
        return true;
    }
}
