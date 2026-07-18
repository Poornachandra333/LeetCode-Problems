class Pair{
    int key;
    int val;
    Pair(int key,int val){
        this.key = key;
        this.val = val;
    }
}
class Solution {
    public int minSetSize(int[] arr) {
        HashMap<Integer,Integer>hm =new HashMap<>();  

        for(int i=0;i<arr.length;i++){
            hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
        }
        PriorityQueue<Pair>pq = new PriorityQueue<>((a,b)->b.val-a.val);
        for(int i:hm.keySet()){
            pq.add(new Pair(i,hm.get(i)));
        }
        int cnt = 0;
        int n = arr.length/2;
        int ans = 0;
        while(!pq.isEmpty()){
            ans +=pq.peek().val;
            cnt++;
            if(ans>=n){
                return cnt;
            }
            pq.poll();
        }
        return 0;
    }   
}