class Solution {
    public int maxValidPairSum(int[] nums, int k) {
        int maxLeftSum = 0;
        int max = 0;
        for(int i=k;i<nums.length;i++){
            maxLeftSum = Math.max(maxLeftSum,nums[i-k]);
            max = Math.max(max,maxLeftSum+nums[i]);
        }
        return max;
    }
}