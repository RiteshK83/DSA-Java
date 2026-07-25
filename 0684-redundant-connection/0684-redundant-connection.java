class Solution {
    int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();

        int n = edges.length;
        parent = new int[n+1];

        for(int i =0; i<= n; i++){
            parent[i]=i;
        }
        for(int [] edge : edges){
            int u = edge[0];
            int v = edge[1];

            int parentU = find(u);
            int parentV = find(v);

            if(parentU == parentV){
                return edge;
            }
            parent[parentU] = parentV;
            

        }
        return new int[0];
    }
    private int find(int node){
        if(parent[node] == node){
            return node;
        }
        return parent[node] = find(parent[node]);
    }
}