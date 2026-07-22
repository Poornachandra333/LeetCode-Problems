class Solution {
    public String removeKdigits(String num, int k) {
        int length = num.length()-k;
        int n = num.length();
        Stack<Character>st = new Stack<>();
        for(int i=0;i<num.length();i++){
            char ch = num.charAt(i);
            while(!st.isEmpty() && st.peek()>ch && k>0){
                st.pop();
                k--;
            }
            st.push(ch);
        }
        while(k>0){
            k--;
            st.pop();
        }
        System.out.println(st);
        StringBuilder res = new StringBuilder();
        while(!st.isEmpty()){
            res.append(st.pop());
        }
        String ans =  res.reverse().toString();
        int i = 0;
        while(i<ans.length() && ans.charAt(i)=='0'){
            i++;
        }
        ans = ans.substring(i);
        return ans.length()==0?"0":ans;
    }
}