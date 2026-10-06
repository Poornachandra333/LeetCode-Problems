class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
        int result[] = new int[numCourses];
        int index = 0;
        while(!queue.isEmpty()){
            int val = queue.poll();
            result[index++] =val;
            for(int x:list.get(val)){
                indegree[x]--;
                if(indegree[x]==0){
                    queue.add(x);
                }
            }
        }
        if(index == numCourses) return result;
        return new int[]{};
    }
}