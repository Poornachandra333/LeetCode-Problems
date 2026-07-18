class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer,Integer>hm = new HashMap<>();
        int cnt = 0;
        for(int i=0;i<nums.length;i++){
            if(hm.containsKey(nums[i])){
                cnt+=hm.get(nums[i]);
                hm.put(nums[i],hm.get(nums[i])+1);
            }
            else{
                hm.put(nums[i],1);
            }
        }
        return cnt;
    }
}