class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(1,0,k,n,new ArrayList<>(),ans);
        return ans;
    }
    private void helper(int start,int sum, int k,int n,List<Integer> current, List<List<Integer>> ans){
        if(current.size() == k && sum == n){
            ans.add(new ArrayList<>(current));
            return;
        }
        if(current.size() >= k || sum > n){
            return;
        }
        for(int i = start; i<=9; i++){
            current.add(i);
            helper(i+1,sum+i,k,n,current,ans);
            current.remove(current.size()-1);
        }
    }
}