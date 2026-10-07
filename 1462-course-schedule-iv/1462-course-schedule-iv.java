class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<List<Integer>>list = new ArrayList<>();
        List<HashSet<Integer>>set = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            set.add(new HashSet<>());
            list.add(new ArrayList<>());
        }
        int indegree[] = new int[numCourses];
        for(int arr[]:prerequisites){
            list.get(arr[0]).add(arr[1]);
            indegree[arr[1]]++;
        }
        List<Boolean>result = new ArrayList<>();
        Queue<Integer>queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int val = queue.poll();
            for(int i:list.get(val)){
                indegree[i]--;
                set.get(i).add(val);
                set.get(i).addAll(set.get(val));
                if(indegree[i]==0){
                    queue.add(i);
                }
            }
        }
        for(int i=0;i<queries.length;i++){
            if(set.get(queries[i][1]).contains(queries[i][0])){
                result.add(true);
            }
            else{
                result.add(false);
            }
        }
        System.out.println(set);
        return result;
    }
}