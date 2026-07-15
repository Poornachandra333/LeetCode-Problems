class Solution {
    public int countPrimes(int n) {
        
        if(n<2){
            return 0;
        }
        boolean isPrime[]=new boolean[n];
        Arrays.fill(isPrime,true);
        for(int i=2;i*i<n;i++){
            if(isPrime[i]){
                for(int j=i*2;j<n;j=j+i){
                    isPrime[j]=false;
                }
            }
        }
        int cnt = 0;
        for(int i = 2;i<n;i++){
            if(isPrime[i]){
                cnt++;
            }
        }
        return cnt;

    }
}