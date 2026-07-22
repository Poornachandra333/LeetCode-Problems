class Solution {
    public int maximumPrimeDifference(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i:nums){
            max = Math.max(i,max);
        }
        boolean isPrime[]=new boolean[max+1];
        Arrays.fill(isPrime,true);
        isPrime[0]=false;
        isPrime[1]=false;
        for(int i=0;i*i<=max;i++){
            if(isPrime[i]){
            for(int j=i*i;j<=max;j+=i){
                isPrime[j]=false;
            }
            }
        }
        int n = nums.length;
        boolean result[]=new boolean[n];
        for(int i=0;i<n;i++){
            result[i]=isPrime[nums[i]];
        }
        boolean front = false;
        boolean back = false;
        int left = 0;
        int right = n-1;
        while(left<=right){
            if(front && back){
                return right-left;
            }
            if(!front && result[left]){
                front = true;
            }
            if(!back && result[right]){
                back = true;
            }
            if(!front){
                left++;
            }
            if(!back){
                right--;
            }
        }
        return 0;
    }
}