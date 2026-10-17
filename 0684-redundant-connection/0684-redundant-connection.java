class Solution {
    public int findParent(int u,int parent[]){
        if(u == parent[u]){
            return u;
        }
        parent[u] = findParent(parent[u],parent);
        return parent[u];
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int parent[] = new int[n+1];
        for(int i=1;i<=n;i++){
            parent[i] = i;
        }
        for(int arr[]:edges){
            int u = arr[0];
            int v = arr[1];
            int pu = findParent(u,parent);
            int pv = findParent(v,parent);
            if(pu == pv){
                return new int[]{u,v};
            }else{
                parent[pu] = pv;
            }
        }
        return new int[]{};
    }
}