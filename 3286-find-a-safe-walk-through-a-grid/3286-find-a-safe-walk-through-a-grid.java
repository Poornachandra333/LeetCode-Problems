class Pair
{
    int row;
    int col;
    int distance;
    Pair(int row,int col,int distance)
    {
        this.row=row;
        this.col=col;
        this.distance=distance;
    }
}
class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m=grid.size();
        int n=grid.get(0).size();
        int dist[][]=new int[m][n];
        PriorityQueue<Pair>queue=new PriorityQueue<>((a,b)->(a.distance-b.distance));
        for(int arr[]:dist){
            Arrays.fill(arr,Integer.MAX_VALUE);
        }
        int directions=4;
        int rowDirections[]={-1,0,1,0};
        int colDirections[]={0,1,0,-1};
        dist[0][0]=grid.get(0).get(0);
        queue.add(new Pair(0,0,dist[0][0]));
        while(!queue.isEmpty())
        {
            int row=queue.peek().row;
            int col=queue.peek().col;
            int distance=dist[row][col];
            queue.poll();
            for(int i=0;i<directions;i++)
            {
                int drow=row+rowDirections[i];
                int dcol=col+colDirections[i];
                if(drow>=0 && dcol>=0 && drow<m && dcol<n){
                    if(distance+grid.get(drow).get(dcol)<dist[drow][dcol]){
                        dist[drow][dcol]=distance+grid.get(drow).get(dcol);
                        queue.add(new Pair(drow,dcol,dist[drow][dcol]));
                    }
                }
            }
        }
        System.out.println(dist[m-1][n-1]);
        if(health<=dist[m-1][n-1]){
            return false;
        }
        return true;
    }
}