class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>>list = new ArrayList<>();
        for(int i=0;i<graph.length;i++){
            list.add(new ArrayList<>());
        }
        int indegree[] = new int[graph.length];
        for(int i=0;i<graph.length;i++){
            indegree[i] = graph[i].length;
            for(int ele:graph[i]){
                list.get(ele).add(i);
            }

        }
        Queue<Integer>queue = new LinkedList<>();
        for(int i=0;i<graph.length;i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
        List<Integer>result = new ArrayList<>();
        while(!queue.isEmpty()){
            int val = queue.poll();
            result.add(val);
            for(int x:list.get(val)){
                indegree[x]--;
                if(indegree[x] == 0){
                    queue.add(x);
                }
            }
        }
        Collections.sort(result);
        return result;
    }
}