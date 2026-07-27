class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer>hs = new HashSet<>();
        
        while(n!=1 && !hs.contains(n)){
            hs.add(n);
            int x = n;
            long sum = 0;
           // System.out.println(1);
            while(x!=0){
                //System.out.println(2);
                int rem = x%10;
                sum += Math.pow(rem,2);
                x/=10;
            }
            n = (int)sum;
        }
        return n==1;
    }
}