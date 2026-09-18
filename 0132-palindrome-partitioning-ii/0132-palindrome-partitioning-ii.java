class Solution {
    public int solve(int start,String s,boolean dp[][],int dpp[]){
        if(s.length()==start){
            return -1;
        }
        if(dpp[start]!=-1){
            return dpp[start];
        }
        int count = Integer.MAX_VALUE;
        for(int end = start;end<s.length();end++){
            if(dp[start][end]){
                count = Math.min(count,1+solve(end+1,s,dp,dpp));
            }
        }
        
        return dpp[start] = count;
    }
    public int minCut(String s) {
        int n = s.length();
        boolean dp[][] = new boolean[n][n];
        for(int len = 1;len<=s.length();len++){
            for(int i = 0;i+len<=s.length();i++){
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
        int ans =  solve(0,s,dp,dpp);
        // for(boolean arr[]:dp){
        //     System.out.println(Arrays.toString(arr));
        // }
       // System.out.println(Arrays.toString(dpp));
        return ans;
    }
}