class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];

        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        int lcs = solve(0,0,word1,word2,dp);

        return word1.length() + word2.length() - 2 * lcs;

    }
    public int solve(int i, int j , String word1, String word2, int[][] dp){
        if(i == word1.length() || j == word2.length()){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(word1.charAt(i) == word2.charAt(j)){
            return 1 + solve(i+1,j+1,word1,word2,dp);
        }
        return dp[i][j] = Math.max(solve(i+1,j,word1,word2,dp), solve(i,j+1,word1,word2,dp));
    }
}