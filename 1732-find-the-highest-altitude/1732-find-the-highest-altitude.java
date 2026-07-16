class Solution {
    public int largestAltitude(int[] gain) {
        int max = 0;
        int n = gain.length;
        int prefixSum[]=new int[n+1];
        prefixSum[0]=0;
        for(int i=1;i<n+1;i++){
            prefixSum[i]=prefixSum[i-1]+gain[i-1];
            max = Math.max(max,prefixSum[i]);
        }
        System.out.println(Arrays.toString(prefixSum));
        return max;
    }
}
