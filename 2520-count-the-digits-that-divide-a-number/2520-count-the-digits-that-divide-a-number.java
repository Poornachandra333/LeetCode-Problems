class Solution {
    public int countDigits(int num) {
        int n = num;
        int cnt = 0;
        while(n!=0){
            int rem = n%10;
            if(num%rem==0){
                cnt++;
            }
            n/=10;
        }
        return cnt;
    }
}