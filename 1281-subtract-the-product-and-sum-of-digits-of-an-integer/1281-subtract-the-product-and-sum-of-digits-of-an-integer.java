class Solution {
    public int subtractProductAndSum(int n) {
        long product = 1;
        long sum = 0;
        while(n!=0){
            int rem = n%10;
            product = rem*product;
            sum = rem+sum;
            n/=10;
        }
        return (int)(product - sum);
    }
}