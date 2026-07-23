import java.util.*;

class Pair {
    int node;
    int cost;

    Pair(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
}

class Tuple {
    int stops;
    int node;
    int cost;

    Tuple(int stops, int node, int cost) {
        this.stops = stops;
        this.node = node;
        this.cost = cost;
    }
}

class Solution {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] flight : flights) {
            int u = flight[0];
            int v = flight[1];
            int cost = flight[2];

            adj.get(u).add(new Pair(v, cost));
        }

        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[src] = 0;

        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(0, src, 0)); // stops, node, cost

        while (!q.isEmpty()) {

            Tuple current = q.poll();

            int stops = current.stops;
            int node = current.node;
            int cost = current.cost;

            if (stops > k) {
                continue;
            }

            for (Pair neighbour : adj.get(node)) {

                int adjNode = neighbour.node;
                int edgeCost = neighbour.cost;

                if (cost + edgeCost < distance[adjNode]) {

                    distance[adjNode] = cost + edgeCost;

                    q.offer(new Tuple(stops + 1, adjNode, cost + edgeCost));
                }
            }
        }

        return distance[dst] == Integer.MAX_VALUE ? -1 : distance[dst];
    }
}