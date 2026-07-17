class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>>hm = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            String s = strs[i];
            char arr[] = s.toCharArray();
            //System.out.println(arr);
            Arrays.sort(arr);
            String p = new String(arr);
            if(hm.containsKey(p)){
                List<String> li = hm.get(p);
                li.add(s);
                hm.put(p,li);
            }
            else{
                List<String>li = new ArrayList<>();
                li.add(s);
                hm.put(p,li);
            }
            //System.out.println(p);
        }
        //System.out.println(hm);
        List<List<String>>list = new ArrayList<>();
        for(String s:hm.keySet()){
            List<String>ans = hm.get(s);
            list.add(ans);
        }
        return list;
    }
}