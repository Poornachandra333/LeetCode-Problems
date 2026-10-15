class Solution {
    public void dfs(int i,boolean visited[],List<List<Integer>>list){
        visited[i] = true;
        for(int x:list.get(i)){
            if(!visited[x]){
                dfs(x,visited,list);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>>list = new ArrayList<>();
        int n = isConnected.length;
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(isConnected[i][j] == 1){
                    list.get(i).add(j);
                }
            }
        }
        boolean visited[] = new boolean[n];
        int count =0 ;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                count++;
                dfs(i,visited,list);
            }
        }
        return count;
    }
}