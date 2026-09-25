class Solution {
    public boolean solve(int start,String s,HashSet<String>hm,int dp[],List<List<String>>list,List<String>ans){
        if(start>=s.length()){
            list.add(new ArrayList<>(ans));
            return true;
        }
        // if(dp[start]!=-1){
        //     return dp[start]==1;
        // }
        for(int end = start+1;end<=s.length();end++){
            String word = s.substring(start,end);
            if(hm.contains(word)){
                ans.add(word);
                if(solve(end,s,hm,dp,list,ans)){
                    dp[start] = 1;
                }
                ans.remove(ans.size()-1);
            }
        }
        dp[start] = 0;
        return false;
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<List<String>>list = new ArrayList<>();
        HashSet<String>hm = new HashSet<>(wordDict);
        int n = s.length();
        int dp[]= new int[n];
        //Arrays.fill(dp,-1);
        solve(0,s,hm,dp,list,new ArrayList<>());
        //System.out.println(list);
        List<String>result = new ArrayList<>();
        for(List<String>li :list){
            String t = String.join(" ",li);
            result.add(t);
        }
        return result;
    }
}