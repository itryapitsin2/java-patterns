package problems.medium.FindTheOriginalArrayOfPrefixXor;

public class Solution2 {

    public int[] findArray(int[] A) {
        for (int i = A.length - 1; i > 0; --i)
            A[i] ^= A[i - 1];
        return A;
    }
}