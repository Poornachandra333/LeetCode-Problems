class Solution {
    public int pivot(int nums[]){
        int start = 0;
        int end = nums.length-1;
        while(start<end){
            int mid = start+(end-start)/2;
            if(nums[mid]>nums[end]){
                start = mid+1;
            }
            else{
                end = mid;
            }
        }
        return start;
    }
    public int solve(int nums[],int left,int right,int target){
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid]<target){
                left = mid+1;

            }
            else{
                right = mid-1;
            }
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        int p = pivot(nums);
        System.out.println(p);
        int left = solve(nums,0,p-1,target);
        int right = solve(nums,p,nums.length-1,target);
        if(left!=-1){
            return left;
        }
        if(right!=-1){
            return right;
        }
        return -1;
    }   
}

