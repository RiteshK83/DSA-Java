class Solution {
    public boolean isMatch(String s, String p) {
        Boolean[][] dp = new Boolean[s.length()+1][p.length()+1];
        return solve(0,0,s,p,dp);
    }
    public boolean solve(int i,int j, String s, String p, Boolean[][] dp){
        if(i == s.length() && j == p.length()){
            return true;
        }
        if(j == p.length()){
            return false;
        }
        if(i == s.length()){
            while(j<p.length()){
                if(p.charAt(j) != '*'){
                    return false;
                }
                j++;
            }
            return true;
        }
        if(dp[i][j] != null){
            return dp[i][j];
        }
        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
            return dp[i][j] = solve(i+1,j+1,s,p,dp);
        }
        if(p.charAt(j) == '*'){
            return dp[i][j] = solve(i,j+1,s,p,dp) || solve(i+1,j,s,p,dp);
        }
        return dp[i][j] = false;
    }
}