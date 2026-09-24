class Solution {
    public int solve(int index,int arr[],List<Integer>list){
        int i = 0;
        while(i<list.size()){
            arr[index++] = list.get(i);
            i++;
        }
        return index;
    }
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer>left = new ArrayList<>();
        List<Integer>equal = new ArrayList<>();
        List<Integer>right = new ArrayList<>();
        for(int r=0;r<nums.length;r++){
            if(pivot == nums[r]){
                equal.add(nums[r]);
            }
            else if(pivot < nums[r]){
                right.add(nums[r]);
            }
            else{
                left.add(nums[r]);
            }

        }
        // System.out.println(left);
        // System.out.println(equal);
        // System.out.println(right);
        int n = nums.length;
        int result[] = new int[n];
        int index = solve(0,result,left);
        index = solve(index,result,equal);
        index = solve(index,result,right);
        return result;
    }
}