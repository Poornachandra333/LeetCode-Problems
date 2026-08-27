class Solution {
    public boolean isValid(HashMap<Character,Integer>hm,HashMap<Character,Integer>duplicate){
        if(duplicate.size()!=hm.size()){
            return false;
        }
        for(char ch:hm.keySet()){
            if(!hm.get(ch).equals(duplicate.get(ch))){
                return false;
            }
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character,Integer>hm = new HashMap<>();
        
        for(int i=0;i<s1.length();i++){
            hm.put(s1.charAt(i),hm.getOrDefault(s1.charAt(i),0)+1);
        }
        HashMap<Character,Integer>duplicate = new HashMap<>();
        int l = 0;
        for(int r=0;r<s2.length();r++){
            duplicate.put(s2.charAt(r),duplicate.getOrDefault(s2.charAt(r),0)+1);
            if(r-l+1>s1.length()){
                duplicate.put(s2.charAt(l),duplicate.get(s2.charAt(l))-1);
                if(duplicate.get(s2.charAt(l))==0){
                    duplicate.remove(s2.charAt(l));
                }
                l++;
            }
            if(r-l+1==s1.length()){
                if(isValid(hm,duplicate)){
                    return true;
                }
            }
        }
        return false;
    }
}