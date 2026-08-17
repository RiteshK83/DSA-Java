class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;

        int[][] dp = new int[n][amount+1];

        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return solve(0,amount,coins,dp);
    }
    public int solve(int i,int amount,int[] coins,int[][] dp){
        if(amount == 0){
            return 1;
        }
        if(i == coins.length){
            return 0;
        }
        if(dp[i][amount] != -1){
            return dp[i][amount];
        }
        int take =0;

        if(coins[i] <= amount){
            take = solve(i,amount-coins[i],coins,dp);
        }
        int notTake = solve(i+1,amount,coins,dp);

        int ways = take+notTake;

        return dp[i][amount] = ways;
    }
}