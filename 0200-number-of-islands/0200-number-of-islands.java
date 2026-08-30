class Pair{
    int row;
    int col;
    Pair(int row,int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public void bfs(int i,int j,boolean visited[][],char grid[][]){
        int m = visited.length;
        int n = visited[0].length;
        visited[i][j]=true;
        Queue<Pair>queue = new LinkedList<>();
        queue.add(new Pair(i,j));
        int rowDirections[] = {-1,0,1,0};
        int colDirections[] = {0,1,0,-1};
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            int row = pair.row;
            int col = pair.col;
            for(int k=0;k<4;k++){
                int rowD = rowDirections[k]+row;
                int colD = colDirections[k]+col;
                if(rowD>=0 && rowD<m && colD>=0 && colD<n && !visited[rowD][colD] && grid[rowD][colD]=='1'){
                    visited[rowD][colD] = true;
                    queue.add(new Pair(rowD,colD));
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean visited[][] = new boolean[m][n];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    count++;
                    bfs(i,j,visited,grid);
                }
            }
        }
        return count;
    }
}