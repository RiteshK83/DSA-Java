class Solution {

    class Edge {
        int node;
        int weight;
        Edge(int node,int weight){
            this.node = node;
            this.weight = weight;
        }
    }
    class Pair {
        int node;
        int dist;
        Pair(int node, int dist){
            this.node = node;
            this.dist = dist;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Edge>> adj = new ArrayList<>();

        for(int i =0; i<= n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] time : times){
            int u = time[0];
            int v = time[1];
            int w = time[2];

            adj.get(u).add(new Edge(v,w));
        }
        int[] distance = new int[n+1];

        Arrays.fill(distance, Integer.MAX_VALUE);
            distance[k] =0;

            PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.dist - b.dist);

            pq.offer(new Pair(k,0));

            while(!pq.isEmpty()){

                Pair curr = pq.poll();

                int node = curr.node;
                int currDist = curr.dist;

                if(currDist > distance[node]){
                    continue;
                }

                for(Edge it : adj.get(node)){
                    int neighbour = it.node;
                    int edgeWeight = it.weight;

                    if(currDist + edgeWeight < distance[neighbour]){
                        distance[neighbour] = currDist + edgeWeight;

                        pq.offer(new Pair(neighbour, distance[neighbour]));
                    }
                }
            }
            int max = 0;
            for(int  i =1; i<=n; i++){
                if(distance[i] == Integer.MAX_VALUE){
                    return -1;
                }
                max = Math.max(max,distance[i]);
            }
            return max;
        
    }
}