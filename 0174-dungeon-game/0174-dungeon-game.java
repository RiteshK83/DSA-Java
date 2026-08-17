class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];

        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return solve(0,0,dungeon,dp);
    }
    public int solve(int i,int j,int[][] dungeon,int[][] dp){
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(i == dungeon.length-1 && j == dungeon[0].length-1){
            int required = Math.max(1,1-dungeon[i][j]);

            return dp[i][j] = required;
        }
        int next;

        if(i == dungeon.length-1){
            next = solve(i,j+1,dungeon,dp);
        }
        else if(j == dungeon[0].length-1){
            next = solve(i+1,j,dungeon,dp);
        }
        else {
            int right = solve(i,j+1,dungeon,dp);
            int down = solve(i+1,j,dungeon,dp);

            next = Math.min(right,down);
        }
        int required = next - dungeon[i][j];

        required = Math.max(1,required);

        return dp[i][j] = required;
    }
}