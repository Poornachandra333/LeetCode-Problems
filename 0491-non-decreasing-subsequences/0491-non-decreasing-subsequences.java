class Solution {
    public void solve(int start,int prev,int nums[],List<List<Integer>>list,List<Integer>ans,HashSet<List<Integer>>hs){
        if(ans.size()>=2){
            if(!hs.contains(ans)){
            hs.add(new ArrayList<>(ans));
            list.add(new ArrayList<>(ans));
            }
        }
        for(int i = start;i<nums.length;i++){
            if(prev==-1 || nums[prev]<=nums[i]){
                ans.add(nums[i]);
                solve(i+1,i,nums,list,ans,hs);
                ans.remove(ans.size()-1);
            }  
        }
    }
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>>list = new ArrayList<>();
        solve(0,-1,nums,list,new ArrayList<>(),new HashSet<>());
        return list;
    }
}