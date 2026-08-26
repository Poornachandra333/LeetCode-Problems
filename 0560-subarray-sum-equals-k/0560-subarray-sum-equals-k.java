class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer>hm = new HashMap<>();
        hm.put(0,1);
        int count = 0;
        int sum = 0;
        for(int i:nums){
            sum+=i;
            if(hm.containsKey(sum-k)){
                int temp=hm.get(sum-k);
                count+=temp;
                
            }
            hm.put(sum,hm.getOrDefault(sum,0)+1); 
        }
        return count;


    }
}