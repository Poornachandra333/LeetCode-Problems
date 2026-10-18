class Solution {
    public void dfs(int i,boolean visited[],List<List<Integer>>list){
        visited[i] = true;
        for(int x:list.get(i)){
            if(!visited[x]){
                dfs(x,visited,list);
            }
        }
    }
    public int makeConnected(int n, int[][] connections) {
        int province = 0;
        List<List<Integer>>list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int edge[]:connections){
            int u = edge[0];
            int v = edge[1];
            list.get(u).add(v);
            list.get(v).add(u);
        }
        boolean visited[] = new boolean[n];
        for(int i =0;i<n;i++){
            if(!visited[i]){
                dfs(i,visited,list);
                province++;
            }
        }
        if(connections.length<n-1){
            return -1;
        }
        return province-1;
    }
}