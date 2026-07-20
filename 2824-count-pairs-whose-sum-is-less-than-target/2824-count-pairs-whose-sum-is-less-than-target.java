class Solution {
    public int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);
        int count = 0;
        for(int i=1;i<nums.size();i++){
            int l = 0;
            int r = i;
            while(l<r){
                int sum = nums.get(l)+nums.get(r);
                System.out.println(sum);
                if(sum<target){    
                    count++;
                }
                l++;

            }
        }
        return count;
    }
}