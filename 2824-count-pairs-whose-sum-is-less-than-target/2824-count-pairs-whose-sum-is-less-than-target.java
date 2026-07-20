class Solution {
    public int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);
        int count = 0;
        int l = 0;
        int r = nums.size()-1;
        while(l<r){
            int sum = nums.get(l)+nums.get(r);
            System.out.println(sum);
            if(sum<target){    
                count+=r-l;
                l++;
            }
            else{
                r--;
            }
        }
        return count;
    }
}