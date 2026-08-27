class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double ans = 0;
        double max = Integer.MIN_VALUE;
        int l = 0;
        int sum = 0;
        for(int r=0;r<nums.length;r++){
            sum +=nums[r];
            if(r-l+1>k){
                sum-=nums[l];
                l++;
            }
            if(r-l+1==k){
                ans = (double)sum/k;
                System.out.println(ans);
                max = Math.max(max,ans);
            }
        }
        return max;
    }
}