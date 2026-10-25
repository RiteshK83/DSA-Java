class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();

        helper(1,n,k,new ArrayList<>(), ans);
        return ans;
    }
    private void helper(int start, int n , int k, List<Integer> current, List<List<Integer>> ans){
        if(current.size()== k){
            ans.add(new ArrayList<>(current));
        }
        for(int i = start; i<= n; i++){
            current.add(i);

            helper(i+1, n, k , current,ans);

            current.remove(current.size()-1);
        }
    }
}