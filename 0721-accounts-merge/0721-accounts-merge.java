class Solution {
    class DisjointSet {
        int[] parent;
        int[] rank;

        public DisjointSet(int n){
            parent = new int[n];
            rank = new int[n];

            for(int i=0; i<n;i++){
                parent[i] = i;
                rank[i] = 0;
            }
        }
        public int findParent(int node){
            if(parent[node] == node){
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
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();

        DisjointSet ds = new DisjointSet(n);
        HashMap<String,Integer> emailToAccount = new HashMap<>();

        for(int i =0; i< n; i++){
            List<String> account = accounts.get(i);
            for(int j =1; j< account.size(); j++){
                String email = account.get(j);

                if(!emailToAccount.containsKey(email)){
                    emailToAccount.put(email,i);
                }
                else {
                     ds.unionByRank(i,emailToAccount.get(email));
                }
            }
        }
        HashMap<Integer,List<String>> mergedEmails = new HashMap<>();

        for(String email : emailToAccount.keySet()){
            int accountIndex = emailToAccount.get(email);

            int parent = ds.findParent(accountIndex);

            mergedEmails.putIfAbsent(parent,new ArrayList<>());
            mergedEmails.get(parent).add(email);
        }
        List<List<String>> ans = new ArrayList<>();

        for (int parent : mergedEmails.keySet()) {
            List<String> emails = mergedEmails.get(parent);
            Collections.sort(emails);
            List<String> account = new ArrayList<>();
            account.add(accounts.get(parent).get(0));
            account.addAll(emails);
            ans.add(account);
        }
        return ans;

    }
}