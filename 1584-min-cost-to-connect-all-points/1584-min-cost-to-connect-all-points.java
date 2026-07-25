class Solution {
    class Pair {
        int node;
        int weight;
        Pair(int node,int weight){
            this.node = node;
            this.weight = weight;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] visited = new boolean[n];

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.weight - b.weight);

        pq.offer(new Pair(0,0));
        int answer = 0;
        while(!pq.isEmpty()){
            Pair current = pq.poll();

            int node = current.node;
            int weight = current.weight;

            if(visited[node]){
                continue;
            }
            visited[node] = true;
            answer += weight;

            for(int next = 0; next<n; next++){
                if(!visited[next]){
                    int distance = Math.abs(points[node][0] - points[next][0]) + Math.abs(points[node][1] - points[next][1]);

                    pq.offer(new Pair(next,distance));
                }
            }
        }
        return answer;
    }
}