class Solution {
    public int solve(int start,String s,boolean dp[][],int dpp[],int k){
        if(s.length()==start){
            return 0;
        }
        if(dpp[start]!=-1){
            return dpp[start];
        }
        int max = solve(start+1,s,dp,dpp,k);
        for(int end = start;end<s.length();end++){
            if(dp[start][end] && end-start+1>=k){
                int ans = Math.max(max,1+solve(end+1,s,dp,dpp,k));
                max = Math.max(max,ans);
            }
        }
        return dpp[start] = max;
    }
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        boolean dp[][] = new boolean[n][n];
        for(int len = 1;len<=n;len++){
            for(int i = 0;i+len<=n;i++){
                int j = i+len-1;
                if(s.charAt(i)==s.charAt(j)){
                    if(len<=2){
                        dp[i][j] = true;
                    }
                    else{
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
            }
        }
        int dpp[] = new int[n];
        Arrays.fill(dpp,-1);
        return solve(0,s,dp,dpp,k);
    }
}