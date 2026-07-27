class Solution {
    public int maxValidPairSum(int[] nums, int k) {
        int n = nums.length;
        int suffixMax[]=new int[n];
        suffixMax[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            suffixMax[i]=Math.max(nums[i],suffixMax[i+1]);
        }
        int max = 0;
        for(int i=0;i+k<n;i++){
            max = Math.max(max,nums[i]+suffixMax[i+k]);
        }
        return max;
    }
}