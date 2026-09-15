class Solution {
    public boolean solve(int start,String s,HashSet<String>list,Boolean dp[]){
        if(start == s.length()){
            return true;
        }
        if(dp[start]!=null){
            return dp[start];
        }
        for(int end = start+1;end<=s.length();end++){
            String word = s.substring(start,end);
            if(list.contains(word) && solve(end,s,list,dp)){
                dp[start] = true;
                return true;
            }
        }
        dp[start] = false;
        return false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String>hs = new HashSet<>(wordDict);
        Boolean dp[] = new Boolean[s.length()+1];
        return solve(0,s,hs,dp);
    }
}