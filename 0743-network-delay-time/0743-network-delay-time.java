class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>>list = new ArrayList<>();
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        }
        for(int arr[]:times){
            list.get(arr[0]).add(new int[]{arr[1],arr[2]});
        }
        int path[] = new int[n+1];
        Arrays.fill(path,Integer.MAX_VALUE);
        path[k] = 0;
        PriorityQueue<int[]>queue = new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));
        queue.add(new int[]{k,0});
        while(!queue.isEmpty()){
            int peek[] = queue.poll();
            int u = peek[0];
            int w = peek[1];
            for(int li[]: list.get(u)){
                int v = li[0];
                int weight = li[1];
                if(w+weight<path[v]){
                    path[v] = w+weight;
                    queue.add(new int[]{v,path[v]});
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i = 1;i<=n;i++){
            if(path[i] == Integer.MAX_VALUE){
                return -1;
            }
            max = Math.max(max,path[i]);
        }
        return max;
    }
}