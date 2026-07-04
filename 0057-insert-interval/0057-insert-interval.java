class Pair{
    int start;
    int end;
    Pair(int start,int end){
        this.start = start;
        this.end = end;
    }
}
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        Pair pair[]=new Pair[n+1];
        for(int i=0;i<n;i++){
            pair[i]=new Pair(intervals[i][0],intervals[i][1]);
        }
        pair[n]=new Pair(newInterval[0],newInterval[1]);
        Arrays.sort(pair,(a,b)->a.start-b.start);
        List<List<Integer>>result = new ArrayList<>();
        List<Integer>list = new ArrayList<>();
        list.add(pair[0].start);
        int last = pair[0].end;
        for(int i=1;i<n+1;i++){
            if(last>=pair[i].start){
                last=Math.max(last,pair[i].end);
            }
            else{
                list.add(last);
                result.add(list);
                list = new ArrayList<>();
                list.add(pair[i].start);
                last = pair[i].end;
            }
        }
        list.add(last);
        result.add(list);
        System.out.println(result);
        int answer[][]=new int[result.size()][2];
        for(int i=0;i<result.size();i++){
            answer[i][0]=result.get(i).get(0);
            answer[i][1]=result.get(i).get(1);
        }
        return answer;
    }
}