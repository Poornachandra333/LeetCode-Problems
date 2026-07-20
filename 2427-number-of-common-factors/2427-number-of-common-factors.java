class Solution {
    public int commonFactors(int a, int b) {
        int min=Math.min(a,b);
        int count=0;
        for(int i=1;i<=min;i++){
            if(a%i==0 && b%i==0){
                System.out.println(i);
                count++;
            }
            // int other=min/i;
            // if(other!=i && a%other==0 && b%other==0){
            //     count++;
            //     System.out.println(min/i);
            // }
        }
        return count;
    }
}