class Solution {
    public int numIdenticalPairs(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int pair = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]){
                pair++;
            }
            else{
                pair=0;
            }
            count+=pair;
        }
        return  count;
    }
}