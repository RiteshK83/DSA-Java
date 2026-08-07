class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];

        for(int[] row : dp){
            Arrays.fill(row,-1);

        }
        return solve(0,1,prices,dp);
    }
    public int solve(int i,int buy,int[] prices,int[][] dp){
        if(i>= prices.length){
            return 0;
        }
        if(dp[i][buy] != -1){
            return dp[i][buy];
        }
        if(buy == 1){
            return dp[i][buy] = Math.max(-prices[i] + solve(i+1,0,prices,dp), solve(i+1,1,prices,dp));
        }
        return dp[i][buy] = Math.max(prices[i] + solve(i+2,1,prices,dp),solve(i+1,0,prices,dp));
    }

}