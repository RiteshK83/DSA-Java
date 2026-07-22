class Solution {
    class Edge {
        int node;
        double probability;

        Edge(int node, double probability){
            this.node = node;
            this.probability = probability;
        }
    }
    class Pair {
        int node;
        double probability;
        Pair(int node, double probability){
            this.node = node;
            this.probability = probability;
        }
        
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        ArrayList<ArrayList<Edge>> adj = new ArrayList<>();

        for(int i=0; i< n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i< edges.length; i++){
        int u = edges[i][0];
        int v = edges[i][1];
        double prob = succProb[i];

        adj.get(u).add(new Edge(v,prob));
        adj.get(v).add(new Edge(u,prob));

        }

        double[] probability = new double[n];

        Arrays.fill(probability,0.0);

        probability[start] = 1.0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Double.compare(b.probability, a.probability));

        pq.offer(new Pair(start,1.0));

        while(!pq.isEmpty()){
            Pair curr = pq.poll();

            int node = curr.node;
            double currProb = curr.probability;

            if(currProb < probability[node]){
                continue;
            }
            if(node == end){
                return currProb;

            }
            for( Edge edge : adj.get(node)){
                int neighbour = edge.node;
                double edgeProb = edge.probability;

                double newProb = currProb * edgeProb;

                if(newProb > probability[neighbour]){
                    probability[neighbour] = newProb;

                    pq.offer(new Pair(neighbour,newProb));
                }
            }
        }
        return 0.0;
    }
}