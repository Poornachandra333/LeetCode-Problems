class Pair{
    int start;
    int finish;
    Pair(int start,int finish){
        this.start = start;
        this.finish = finish;
    }
}
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Pair pair[]=new Pair[n];
        for(int i=0;i<n;i++){
            pair[i]=new Pair(intervals[i][0],intervals[i][1]);
            System.out.println(intervals[i][0]+" "+intervals[i][1]);
        }
        Arrays.sort(pair,(a,b)->(a.finish-b.finish));
        int count = 0;
        int last = pair[0].finish;
        for(int i=1;i<n;i++){
            if(last>pair[i].start){
                count++;
            }
            else{
                last = pair[i].finish;
            }
            System.out.println(last);
        }
        return count;

    }
}