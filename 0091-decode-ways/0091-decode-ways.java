class Solution {
    public int solve(int start,String s,int dp[]){
        if(start == s.length()){
            return 1;
        }
        if(dp[start]!=-1){
            return dp[start];
        }
        if(s.charAt(start)=='0'){
            return dp[start] =0;
        }
        int count = 0;
        for(int end = start+1;end<=Math.min(start+2,s.length());end++){
            String t = s.substring(start,end);
            long val = Long.parseLong(t);
            char ch = (char)(64+val);
            if(ch>='A' && ch<='Z'){
                int c = solve(end,s,dp);
                count+=c;
            }
        }
        return dp[start] = count;
    }
    public int numDecodings(String s) {
        int n = s.length();
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        if(s.charAt(0)=='0'){
            return 0;
        }
        return solve(0,s,dp);
    }
}