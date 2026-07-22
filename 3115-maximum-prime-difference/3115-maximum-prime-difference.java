class Solution {
    public int maximumPrimeDifference(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i:nums){
            max = Math.max(i,max);
        }
        System.out.println(max);
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
        System.out.println(Arrays.toString(isPrime));
        int n = nums.length;
        boolean result[]=new boolean[n];
        for(int i=0;i<n;i++){
            result[i]=isPrime[nums[i]];
        }
        System.out.println(Arrays.toString(result));
        int left = 0;
        for(int i=0;i<n;i++){
            if(result[i]){
                left = i;
                break;
            }
        }
        int right = n-1;
        for(int i=n-1;i>=0;i--){
            if(result[i]){
                right = i;
                break;
            }
        }
        return right - left;
    }
}