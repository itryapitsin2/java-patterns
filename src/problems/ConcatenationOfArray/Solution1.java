package problems.ConcatenationOfArray;

public class Solution1 {
    public int[] getConcatenation(int[] nums) {
        int[] result = new int[nums.length * 2];
        for(int i = 0; i < nums.length; i++) {
            result[i] = nums[i];
            result[nums.length + i] = nums[i];
        }
        System.gc();
        return result;
    }
}
