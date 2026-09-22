class Solution {
    public boolean solve(int start,String s,int dp[],HashSet<String>hs){
        if(start == s.length()){
            return true;
        }
        if(dp[start]!=-1){
            return dp[start]==1;
        }
        for(int end = start+1;end<=s.length();end++){
            String word = s.substring(start,end);
            if(hs.contains(word) && solve(end,s,dp,hs)){
                dp[start] = 1;
                return true;
            }
        }
        dp[start] = 0;
        return false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        HashSet<String>hs = new HashSet<>(wordDict);
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        return solve(0,s,dp,hs);
    }
}