class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        HashMap<Integer,Integer>hm = new HashMap<>();
        hm.put(0,-1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(hm.containsKey(sum%k)){
                int temp = hm.get(sum%k);
                if(i-temp>=2){
                    return true;
                }

            }else{
            hm.put(sum%k,i);
            }
        }
        return false;

    }
}