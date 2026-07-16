class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int res[] = new int[n];
        for(int i=0;i<res.length;i++){
            res[i]=nums[i];
        }
        Arrays.sort(res);
        HashMap<Integer,Integer>hm = new HashMap<>();
        for(int i=0;i<res.length;i++){
            if(!hm.containsKey(res[i])){
                hm.put(res[i],i);
            }
        }
        int ans[]=new int[n];
        for(int i=0;i<nums.length;i++){
            ans[i]=hm.get(nums[i]);
        }
        return ans;
    }
}