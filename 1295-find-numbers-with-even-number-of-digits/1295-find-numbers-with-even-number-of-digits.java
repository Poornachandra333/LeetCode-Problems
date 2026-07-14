class Solution {
    public int findNumbers(int[] nums) {
        int cnt = 0;
        for(int i:nums){
            String res = String.valueOf(i);
            if(res.length()%2==0){
                cnt++;
            }
        }
        return cnt;
    }
}