class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean dp[][] = new boolean[n][n];
        int count =0 ;
        for(int len=1;len<=s.length();len++){
            for(int i=0;i+len<=s.length();i++){
                int j = i+len-1;
                if(s.charAt(i)==s.charAt(j)){
                    if(len<=2){
                        dp[i][j] = true;
                        count++;
                    }
                    else{
                        dp[i][j] = dp[i+1][j-1];
                        count = count+((dp[i][j])?1:0);
                    }
                }
            }
        }
        
        return count;
    }
}