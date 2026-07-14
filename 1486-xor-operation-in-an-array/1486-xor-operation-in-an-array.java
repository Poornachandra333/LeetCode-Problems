class Solution {
    public int xorOperation(int n, int start) {
        int sum  = 0;
        int i = 1;
        while(i<=n){
            sum=sum^start;
            start+=2;
            i++;
            System.out.println(sum);
        }
        return sum;
    }
}