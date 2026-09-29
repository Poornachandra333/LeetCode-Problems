class Solution {
    public int solve(int start,int dp[],String s){
        if(start == s.length()){
            return 1;
        }
        if(dp[start]!=-1){
            return dp[start];
        }
        if(s.charAt(start)=='0'){
            return 0;
        }
        int ans = 0;
        for(int end = start;end<Math.min(start+2,s.length());end++){
            String word = s.substring(start,end+1);
            int val = Integer.parseInt(word)+64;
            if(val>=65 && val<=90){
                ans+=solve(end+1,dp,s);
            }
        }
        return dp[start] = ans;
    }
    public int numDecodings(String s) {
        int n = s.length();
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        return solve(0,dp,s);
    }
}