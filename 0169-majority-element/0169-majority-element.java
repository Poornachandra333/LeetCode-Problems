class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer>hm = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        int maxVal = 0;
        int maxFreq = 0;
        for(int i:hm.keySet()){
            if(maxFreq<hm.get(i)){
                maxFreq = hm.get(i);
                maxVal = i;
            }
            
        }
        return maxVal;
    }
}