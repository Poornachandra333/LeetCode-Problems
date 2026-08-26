class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        HashMap<Character,Integer>left = new HashMap<>();
        HashMap<Character,Integer>right = new HashMap<>();
        for(int i=0;i<s.length();i++){

            left.put(s.charAt(i),left.getOrDefault(s.charAt(i),0)+1);
            right.put(t.charAt(i),right.getOrDefault(t.charAt(i),0)+1);
        }
        for(char ch:left.keySet()){
            if(!left.get(ch).equals(right.get(ch))){
                return false;
            }
        }
        return true;
    }
}