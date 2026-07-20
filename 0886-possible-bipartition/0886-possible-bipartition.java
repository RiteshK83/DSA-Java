class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i =0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge : dislikes){
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        int[] color = new int[n+1];
        Arrays.fill(color,-1);

        for(int i =0; i< n; i++){
            if(color[i] == -1){
                if(!bfs(i,graph,color)){
                    return false;
                }
            }
        }
        return true;
    }
    private boolean bfs(int start, List<List<Integer>> graph, int[] color){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        color[start] = 0;

        while(!q.isEmpty()){
            int node = q.poll(); 

            for(int  neighbour : graph.get(node)){
                if(color[neighbour] == -1){
                    color[neighbour] = 1- color[node];
                    q.offer(neighbour);
                }
                else {
                     if(color[neighbour] == color[node]){
                        return false;
                     }
                }
            }
        }
         return true; 

    }
}