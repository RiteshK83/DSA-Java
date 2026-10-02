class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans  = new ArrayList<>();

        helper(0,0,"", ans,n);

        return ans;
    }
    private void helper(int open , int close, String current, List<String> ans, int n){

        if(current.length() == 2*n){
            ans.add(current);
            return;
        }
        if(open < n){
            helper(open +1,close,current+"(", ans,n);
        }
        if(close< open){
            helper(open ,close+1,current+")", ans,n);
        }
    }
}