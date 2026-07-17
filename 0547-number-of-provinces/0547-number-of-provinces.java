class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        boolean[] visited = new boolean[n];
        int provinces =0;
        for(int i =0; i<n; i++){
            if(!visited[i]){
                provinces++;
                bfs(i,isConnected,visited);
            }
        }
        return provinces;
    }
    private void bfs(int start, int[][] isConnected, boolean[] visited){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start]=true;
        while(!q.isEmpty()){
            int node = q.poll();
            for(int i =0; i < isConnected.length;i++){
                if(isConnected[node][i] == 1 && !visited[i]){
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }


     }
}