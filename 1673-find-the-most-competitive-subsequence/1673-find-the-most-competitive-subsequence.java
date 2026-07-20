class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        int n = nums.length;
        int result[] = new int[k];
        Stack<Integer>st = new Stack<>();
        for(int i=0;i<nums.length;i++){
            int val = nums[i];
            while(!st.isEmpty() && st.peek()>val && st.size()+(n-i)>k){
                st.pop();
            }
            st.push(val);
        }
        System.out.println(st);
        int index=0;
        for(int i:st){
            result[index++]=i;
            if(index==k){
                break;
            }
        }
        return result;
    }
}