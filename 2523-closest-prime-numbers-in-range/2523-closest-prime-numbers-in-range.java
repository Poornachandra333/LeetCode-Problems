class Solution {

    public int[] closestPrimes(int left, int right) {
        
        boolean isPrime[]=new boolean[right+1];
        Arrays.fill(isPrime,true);
        isPrime[0]=false;
        isPrime[1]=false;
        for(int i=2;i*i<=right;i++){
            if(isPrime[i]){
            for(int j=i*i;j<=right;j+=i){
                isPrime[j]=false;
            }
            }
        }
        //System.out.println(Arrays.toString(isPrime));
        int res[]=new int[2];
        res[0]=-1;
        res[1]=-1;
        int prev = -1;
        int minDiff = Integer.MAX_VALUE;
        for(int i = left;i<=right;i++){
            if(isPrime[i]){
                if(prev!=-1){
                    if(i-prev<minDiff){
                        minDiff = i-prev;
                        res[0]=prev;
                        res[1]=i;
                    }
                }
                prev = i;
            }
        }
        return res;
    }
}