class Solution {
    class DisjointSet {
        int[] parent;
        int[] rank;
        
        public DisjointSet(int n){
            parent = new int[n];
            rank = new int[n];

            for(int i=0; i<n; i++){
                parent[i] = i;
                rank[i] = 0;
            }
        }
        public int findParent(int node){
            if(node == parent[node]){
                return node;
            }
            return parent[node] = findParent(parent[node]);
        }
        public void unionByRank(int u, int v){
            int ulp_u = findParent(u);
            int ulp_v = findParent(v);

            if(ulp_u == ulp_v){
                return;
            }
            if(rank[ulp_u] < rank[ulp_v]){
                parent[ulp_u] = ulp_v;
            }
            else if(rank[ulp_u] > rank[ulp_v]){
                parent[ulp_v] = ulp_u;
            }
            else {
                parent[ulp_v] = ulp_u;
                rank[ulp_u]++;
            }
        }
    }
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1){
            return -1;
        }
        DisjointSet ds = new DisjointSet(n);

        for(int[] edge : connections){
            int u = edge[0];
            int v = edge[1];

            if(ds.findParent(u) != ds.findParent(v)){
                ds.unionByRank(u,v);
            }
        }
        int components = 0;

        for (int i = 0; i < n; i++) {

            if (ds.findParent(i) == i) {
                components++;
            }
        }

        return components - 1;
    }
}