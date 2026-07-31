class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return solve(0,0,grid,dp);
    }
    public int solve(int i,int j,int[][] grid,int[][] dp){
        int m = grid.length;
        int n = grid[0].length;

        if(i>=m || j>=n){
            return Integer.MAX_VALUE;
        }
        if(i==m-1 && j==n-1){
            return grid[i][j];
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int right = solve(i,j+1,grid,dp);
        int down = solve(i+1,j,grid,dp);

        dp[i][j] = grid[i][j] + Math.min(right,down);

        return dp[i][j];
    }
}