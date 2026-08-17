class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int[][] dp = new int[n][amount+1];

        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        int ans = solve(0,coins,amount,dp);

        if(ans == Integer.MAX_VALUE){
            return -1;
        }
        return ans;
    }
    public int solve(int i,int[] coins,int amount,int[][] dp){
        if(amount == 0){
            return 0;
        }
        if(i == coins.length){
            return Integer.MAX_VALUE;
        }
        if(dp[i][amount] != -1){
            return dp[i][amount];
        }
        int take = Integer.MAX_VALUE;

        if(coins[i] <= amount){
            int result = solve(i,coins,amount-coins[i],dp);
            if(result != Integer.MAX_VALUE){
                take = 1 + result;
            }
        }
        int notTake = solve(i+1,coins,amount,dp);

        return dp[i][amount] = Math.min(take,notTake);
    }
}