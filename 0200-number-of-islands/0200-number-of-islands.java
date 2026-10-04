class Pair{
    int row;
    int col;
    Pair(int row,int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public void bfs(int i,int j,char grid[][],boolean visited[][]){
        int rowDirections[] = {0,-1,0,1};
        int colDirections[] = {-1,0,1,0};
        int m = grid.length;
        int n= grid[0].length;
        Queue<Pair>queue = new LinkedList<>();
        queue.add(new Pair(i,j));
        while(!queue.isEmpty()){
            int row = queue.peek().row;
            int col = queue.peek().col;
            queue.poll();
            for(int k = 0;k<4;k++){
                int drow = row+rowDirections[k];
                int dcol = col+colDirections[k];
                if(drow>=0 && dcol>=0 && drow<m && dcol<n && !visited[drow][dcol] && grid[drow][dcol]=='1'){
                    queue.add(new Pair(drow,dcol));
                    visited[drow][dcol] = true;
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count =0 ;
        boolean visited[][] = new boolean[m][n];
        for(int i = 0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    bfs(i,j,grid,visited);
                    count++;
                }
            }
        }
        return count;
    }
}