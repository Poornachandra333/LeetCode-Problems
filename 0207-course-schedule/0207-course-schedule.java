class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>>list = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            list.add(new ArrayList<>());
        }
        int indegree[] = new int[numCourses];
        for(int arr[]:prerequisites){
            list.get(arr[1]).add(arr[0]);
            indegree[arr[0]]+=1;
        }
        Queue<Integer>queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }
        int count = 0 ;
        while(!queue.isEmpty()){
            count++;
            int val = queue.poll();
            for(int x:list.get(val)){
                indegree[x]--;
                if(indegree[x]==0){
                    queue.add(x);
                }
            }
        }
        if(numCourses == count) return true;
        return false;
    }
}