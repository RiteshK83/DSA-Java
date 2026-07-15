class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
      List<List<Integer>> graph = new ArrayList<>();

      for(int i =0; i< n;i++){
        graph.add(new ArrayList<>());
      }
      for(int[] edge : edges){
        int u = edge[0];
        int v = edge[1];

        graph.get(u).add(v);
        graph.get(v).add(u);
      }
      Queue<Integer> queue = new LinkedList<>();
      boolean[] visited = new boolean[n];

      queue.offer(source);
      visited[source] = true;

      while(!queue.isEmpty()){
        int node = queue.poll();

        if(node == destination){
            return true;
        }
        for(int neighbour : graph.get(node)){
            if(!visited[neighbour]){
                visited[neighbour] = true;
                queue.offer(neighbour);
            }
        }
      }
      return false;

    }
}