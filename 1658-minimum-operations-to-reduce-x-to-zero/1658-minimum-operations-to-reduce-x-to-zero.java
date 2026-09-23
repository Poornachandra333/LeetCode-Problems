class Solution {
    public int minOperations(int[] nums, int k) {
        int sum = 0;
        for(int i:nums){
            sum+=i;
        }
        int n = nums.length;
        int max = -1;
        int target = sum-k;
        sum = 0;
        int l = 0;
        for(int r=0;r<nums.length;r++){
            sum+=nums[r];
            while(l<=r && sum>target){
                sum-=nums[l];
                l++;
            }
            if(sum==target){
                max = Math.max(max,r-l+1);
            }
        }
        if(max==-1){
            return -1;
        }
        return n - max;
    }
}