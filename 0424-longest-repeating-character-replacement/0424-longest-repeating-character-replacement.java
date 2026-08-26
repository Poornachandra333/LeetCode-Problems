class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer>hm = new HashMap<>();
        int l =0;
        int max =0;
        int maxFreq = 0;
        for(int r=0;r<s.length();r++){
            hm.put(s.charAt(r),hm.getOrDefault(s.charAt(r),0)+1);
            maxFreq = Math.max(maxFreq,hm.get(s.charAt(r)));
            while((r-l+1)-maxFreq>k){
                hm.put(s.charAt(l),hm.get(s.charAt(l))-1);
                if(hm.get(s.charAt(l))==0){
                    hm.remove(s.charAt(l));
                }
                l++;
                for(char ch:hm.keySet()){
                    maxFreq = Math.max(maxFreq,hm.get(ch));
                }
            }
            max = Math.max(max,r-l+1);
        }  
        return max;
    }
}
