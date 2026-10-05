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
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair>queue = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    queue.add(new Pair(i,j,0));
                }
            }
        }
        int rowDirections[] = {0,-1,0,1};
        int colDirections[] = {-1,0,1,0};
        int ans =0;
        while(!queue.isEmpty()){
            int row = queue.peek().row;
            int col = queue.peek().col;
            int step = queue.peek().step;
            ans = step;
            queue.poll();
            for(int i=0;i<4;i++){
                int rd = row+rowDirections[i];
                int cd = col+colDirections[i];
                if(rd>=0 && cd>=0 && rd<m && cd<n && grid[rd][cd]==1){
                    queue.add(new Pair(rd,cd,step+1));
                    grid[rd][cd]=2;
                }
            }
        }
        //System.out.println(Arrays.deepToString(grid)+" "+ans);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 0) continue;
                if(grid[i][j]==1) return -1;
            }
        }
        return ans;
    }
}