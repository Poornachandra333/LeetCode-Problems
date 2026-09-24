class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int result[] = new int[n];
        List<Integer>positive = new ArrayList<>();
        List<Integer>negative = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(nums[i]>0){
                positive.add(nums[i]);
            }
            else{
                negative.add(nums[i]);
            }
        }
        int index = 0;
        for(int i=0;i<n/2;i++){
            result[index++] = positive.get(i);
            result[index++] = negative.get(i);
        }
        return result;
    }
}