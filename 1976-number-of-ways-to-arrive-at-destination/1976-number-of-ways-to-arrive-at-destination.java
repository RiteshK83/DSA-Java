class Solution {
    class Pair {
        int node;
        long dist;

        Pair(int node, long dist){
            this.node = node;
            this.dist = dist;
        }
    }
    public int countPaths(int n, int[][] roads) {
        int mod = (int)(1e9+7);
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i =0; i< n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] road : roads){
            int u = road[0];
            int v = road[1];
            int w = road[2];

            adj.get(u).add(new Pair(v,w));
            adj.get(v).add(new Pair(u,w));
        }
        long[] distance = new long[n];
        long[] ways = new long[n];

        Arrays.fill(distance,Long.MAX_VALUE);

        distance[0] = 0;

        ways[0] = 1;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Long.compare(a.dist,b.dist));

        pq.offer(new Pair(0,0));

        while(!pq.isEmpty()){
            Pair curr = pq.poll();

            int node = curr.node;
            long currDist = curr.dist;

            if(currDist > distance[node]){
                continue;
            }
            for(Pair edge : adj.get(node)){
                int neighbour = edge.node;
                long edgeWeight = edge.dist;

                long newDistance = currDist + edgeWeight;

                if(newDistance < distance[neighbour]){
                    distance[neighbour] = newDistance;

                    ways[neighbour] = ways[node];

                    pq.offer(new Pair(neighbour,newDistance));
                }
                else if(newDistance == distance[neighbour]){
                    ways[neighbour] = (ways[neighbour] + ways[node]) % mod;
                }
            }
        }
        return (int)(ways[n - 1] % mod);
    }
}