class Solution {
    public boolean isValid(HashMap<Character,Integer>hm,HashMap<Character,Integer>curr){
        for(char ch:hm.keySet()){
            if(!curr.containsKey(ch) || hm.get(ch)>(curr.get(ch))){
                return false;
            }
        }
        return true;
    }
    public String minWindow(String s, String t) {
        HashMap<Character,Integer>hm = new HashMap<>();
        for(int i=0;i<t.length();i++){
            hm.put(t.charAt(i),hm.getOrDefault(t.charAt(i),0)+1);
        }
        int l = 0;
        int min = Integer.MAX_VALUE;
        HashMap<Character,Integer>curr = new HashMap<>();
        StringBuilder ans = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        for(int r=0;r<s.length();r++){
            sb.append(s.charAt(r));
            curr.put(s.charAt(r),curr.getOrDefault(s.charAt(r),0)+1);
            while(r-l+1>=t.length() && isValid(hm,curr)){
                if(min>r-l+1){
                    min = r-l+1;
                    ans = new StringBuilder(sb);
                }
                sb.deleteCharAt(0);
                curr.put(s.charAt(l),curr.get(s.charAt(l))-1);
                if(curr.get(s.charAt(l))==0){
                    curr.remove(s.charAt(l));
                }
                l++;
            }
        }
        return ans.toString();
    }
}