class Solution {
    public String smallestSubsequence(String s) {
        Stack<Character>st = new Stack<>();
        int last[] = new int[26];
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            last[ch-'a']=i;
        }
        //System.out.println(Arrays.toString(last));
        boolean visited[]=new boolean[26];
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(visited[ch-'a']){
                continue;
            }
            while(!st.isEmpty() && st.peek()>ch && last[st.peek()-'a']>i){
                char remove = st.pop();
                visited[remove-'a']=false;
            }
            st.push(ch);
            visited[ch-'a']=true;
        }
        System.out.println(st);
        StringBuilder res = new StringBuilder();
        while(!st.isEmpty()){
            res.append(st.pop());
        }
        return res.reverse().toString();
    }
}