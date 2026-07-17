class Solution {
    public int maxSum(int[] nums) {
  
        
        HashMap<Integer,List<Integer>>hm = new HashMap<>();
        for(int i:nums){
            int m = Integer.MIN_VALUE;
            int x = i;
            while(x!=0){
                int rem = x%10;
                m = Math.max(m,rem);
                x/=10;
            }
            if(hm.containsKey(m)){
                List<Integer>list = hm.get(m);
                list.add(i);
                hm.put(m,list);
            }
            else{
                List<Integer>list = new ArrayList<>();
                list.add(i);
                hm.put(m,list);
            }
        }
        int max = -1;
       // System.out.println(hm);
        for(int i:hm.keySet()){
            if(hm.get(i).size()>1){
                List<Integer>list = hm.get(i);
                Collections.sort(list);
                //System.out.println(list);
                int n = list.size();
                int result = list.get(n-1)+list.get(n-2);
                max = Math.max(max,result);
            }
        }
        // List<Integer>list = new ArrayList<>();
        // for(int i:hm.keySet()){
        //     if(max == hm.get(i)){
        //         list.add(i);
        //     }
        // }
        // Collections.sort(list);
        // int n = list.size();
        // System.out.println(hm+" "+max+" "+list);
        // if(list.size()>1){
        //     return list.get(n-1)+list.get(n-2);
        // }
        return max;
    }
}