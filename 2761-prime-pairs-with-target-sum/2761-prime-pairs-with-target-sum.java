class Solution {
    public List<List<Integer>> findPrimePairs(int n) {
        boolean isPrime[]=new boolean[n+1];
        Arrays.fill(isPrime,true);
        for(int i=2;i<=Math.sqrt(n);i++){
            if(isPrime[i]){
                for(int j=i*i;j<=n;j+=i){
                    isPrime[j]=false;
                }
            }
        }
       // System.out.println(Arrays.toString(isPrime));
        List<Integer>nums = new ArrayList<>();
        for(int i=2;i<=n;i++){
            if(isPrime[i]){
                nums.add(i);
            }
        }
       // System.out.println(nums);
        List<List<Integer>>list = new ArrayList<>();
        int l = 0;
        int r = nums.size()-1;
        while(l<=r){
            int sum = nums.get(l)+nums.get(r);
            if(sum == n){
                List<Integer>curr = new ArrayList<>();
                curr.add(nums.get(l));
                curr.add(nums.get(r));
                l++;
                r--;
                list.add(curr);
            }
            else if(sum<n){
                l++;
            }
            else{
                r--;
            }
        }
        return list;
    }
}