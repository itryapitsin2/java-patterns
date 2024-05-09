package problems.ShuffleTheArray;

class Solution1 {
    public int[] shuffle(int[] nums, int n) {
        int center = (nums.length / 2);
        int[] nums2 = new int[nums.length];
        for(int i = 0; i < center; i++) {
            nums2[2*i] = nums[i];
            nums2[2*i+1] = nums[center+i];
        }
        return nums2;
    }
}