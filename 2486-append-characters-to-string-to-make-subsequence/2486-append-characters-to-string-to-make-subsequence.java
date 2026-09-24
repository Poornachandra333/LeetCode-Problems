class Solution {
    public int appendCharacters(String s, String t) {
        int l = 0;
        int r = 0;
        int m = s.length();
        int n = t.length();
        while(l<m && r<n){
            if(s.charAt(l)==t.charAt(r)){
                l++;
                r++;
            }
            else{
                l++;
            }
        }
        return n-r;
    }
}