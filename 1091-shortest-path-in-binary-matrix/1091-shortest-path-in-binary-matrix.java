class Pair{
    int row;
    int col;
    int step;
    Pair(int row,int col,int step){
        this.row = row;
        this.col = col;
        this.step = step;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int rowDirections[] = {0,-1,-1,-1,0,1,1,1};
        int colDirections[] = {-1,-1,0,1,1,1,0,-1};
        Queue<Pair>queue = new LinkedList<>();
        if(grid[0][0]==1) return -1;
        queue.add(new Pair(0,0,1));
        boolean visited[][] = new boolean[m][n];
        visited[0][0] = true;
        while(!queue.isEmpty()){
            int row = queue.peek().row;
            int col = queue.peek().col;
            int step = queue.peek().step;
            if(row == m-1 && col == n-1){
                return step;
            }
            queue.poll();
            for(int i=0;i<8;i++){
                int rd = row+rowDirections[i];
                int cd = col+colDirections[i];
                if(rd>=0 && cd>=0 && rd<m && cd<n && grid[rd][cd]==0 && !visited[rd][cd]){
                    queue.add(new Pair(rd,cd,step+1));
                    visited[rd][cd] = true;
                }
            }
        }
        return -1;
    }
}