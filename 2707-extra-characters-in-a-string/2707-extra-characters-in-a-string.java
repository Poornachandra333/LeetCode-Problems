class Solution {
    public int solve(int start,String s,int dp[],HashSet<String>hs){
        if(start == s.length()){
            return 0;
        }
        if(dp[start]!=Integer.MAX_VALUE){
            return  dp[start];
        }
        int min = 1+solve(start+1,s,dp,hs);
        for(int end = start+1;end<=s.length();end++){
            String word = s.substring(start,end);
            if(hs.contains(word)){
                min = Math.min(min,solve(end,s,dp,hs));
            }
        }
        return dp[start] = min;
    }
    public int minExtraChar(String s, String[] dictionary) {
        HashSet<String>hs = new HashSet<>();
        for(int i=0;i<dictionary.length;i++){
            hs.add(dictionary[i]);
        }
        int n = s.length();
        int dp[] = new int[n];
        Arrays.fill(dp,Integer.MAX_VALUE);
        return solve(0,s,dp,hs);

    }
}