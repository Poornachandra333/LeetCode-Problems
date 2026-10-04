class Pair{
    int row;
    int col;
    Pair(int row,int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        boolean visited[][] = new boolean[m][n];
        Queue<Pair>queue = new LinkedList<>();
        queue.add(new Pair(sr,sc));
        int val = image[sr][sc];
        int rowDirections[]={0,-1,0,1};
        int colDirections[]={-1,0,1,0};
        while(!queue.isEmpty()){
            int row = queue.peek().row;
            int col = queue.peek().col;
            queue.poll();
            image[row][col] = color;
            for(int i=0;i<4;i++){
                int drow = row+rowDirections[i];
                int dcol = col+colDirections[i];
                if(drow>=0 && drow<m && dcol>=0 && dcol<n && !visited[drow][dcol] && image[drow][dcol]==val){
                    visited[drow][dcol] = true;
                    queue.add(new Pair(drow,dcol));
                }
            }
        }
        return image;
    }
}