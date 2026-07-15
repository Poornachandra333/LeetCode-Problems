class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        int res = 0;
        int n = x;
        while(n!=0){
            int rem  = n%10;
            n /=10;
            res = res*10+rem;
        }
        System.out.println(x);
        return res == x;
    }
}