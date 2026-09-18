class Solution {
    public void solve(int start,String s,boolean dp[][],List<List<String>>list,List<String>ans){
        if(s.length()==start){
            list.add(new ArrayList<>(ans));
        }
        for(int end = start;end<s.length();end++){
            if(dp[start][end]){
                ans.add(s.substring(start,end+1));
                solve(end+1,s,dp,list,ans);
                ans.remove(ans.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
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
        List<List<String>>list = new ArrayList<>();
        solve(0,s,dp,list,new ArrayList<>());
        return list;
    }
}