class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        HashSet<List<Integer>>hs = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            int j = i+1;
            int k = n-1;
            while(j<k){
                if(nums[i]+nums[j]+nums[k]==0){
                    List<Integer>li = new ArrayList<>();
                    li.add(nums[i]);
                    li.add(nums[j]);
                    li.add(nums[k]);
                    hs.add(li);
                    j++;
                    k--;
                }
                else if(nums[i]+nums[j]+nums[k]<0){
                    j++;
                }
                else{
                    k--;
                }
            }
        }
        //System.out.println(hs);
        List<List<Integer>>list = new ArrayList<>();
        for(List<Integer>l:hs){
            list.add(l);
        }
        return list;
    }
}