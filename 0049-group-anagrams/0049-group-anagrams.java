class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character,Integer>,List<String>>hm = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            HashMap<Character,Integer>unique = new HashMap<>();
            for(int j=0;j<strs[i].length();j++){
                if(unique.containsKey(strs[i].charAt(j))){
                    int temp = unique.get(strs[i].charAt(j));
                    unique.put(strs[i].charAt(j),temp+1);
                }
                else{
                    unique.put(strs[i].charAt(j),1);
                }
            }
            if(hm.containsKey(unique)){
                List<String>list = hm.get(unique);
                list.add(strs[i]);
                hm.put(unique,list);
            }
            else{
                List<String>list = new ArrayList<>();
                list.add(strs[i]);
                hm.put(unique,list);
            }
        }
        //System.out.println(hm);
        List<List<String>>ans = new ArrayList<>();
        for(HashMap<Character,Integer> h :hm.keySet())
        {
            List<String>res = new ArrayList<>(hm.get(h));
            ans.add(res);
        }
        return ans;
    }
}