class Solution {
    public int minInsertions(String s) {
        String rev = new StringBuilder(s).reverse().toString();

        int[][] dp = new int[s.length()][s.length()];

        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        int lps = solve(0,0,s,rev,dp);
        return s.length()-lps;
    }
    public int solve(int i,int j,String s,String rev,int[][] dp){
        if(i == s.length() || j == rev.length()){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if (s.charAt(i) == rev.charAt(j)) {
            return dp[i][j] = 1 + solve(i + 1, j + 1, s, rev, dp);
        }
         return dp[i][j] = Math.max(
                solve(i + 1, j, s, rev, dp),
                solve(i, j + 1, s, rev, dp)
        );
    }
}