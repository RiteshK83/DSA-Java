class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i =0; i< numCourses; i++){
            graph.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];

        for(int[] pre : prerequisites){
            int course = pre[0];
            int prerequisite = pre[1];

            graph.get(prerequisite).add(course);
            indegree[course]++;
        }
        Queue<Integer> q = new LinkedList<>();

        for(int i =0; i< numCourses; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }
        List<Integer> ans = new ArrayList<>();

        while(!q.isEmpty()){
            int current = q.poll();
            ans.add(current);

            for(int neighbour : graph.get(current)){
                indegree[neighbour]--;

                if(indegree[neighbour] == 0){
                    q.offer(neighbour);
                }
            }
        }
        if(ans.size() != numCourses){
            return new int[0];
        }
        int[] result = new int[numCourses];
        for(int i =0; i< numCourses; i++){
            result[i] = ans.get(i);
        }
        return  result;
    }
}