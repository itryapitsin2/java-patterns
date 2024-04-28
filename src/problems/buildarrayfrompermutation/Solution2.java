package problems.buildarrayfrompermutation;

public class Solution2 {
    public int[] buildArray(int[] nums) {
        aPermutation(nums,0);
        return nums;
    }
    void aPermutation(int[] nums,int start){
        if(start<nums.length){
            int result=nums[nums[start]];
            aPermutation(nums,start+1);
            nums[start]=result;
        }
    }
}
