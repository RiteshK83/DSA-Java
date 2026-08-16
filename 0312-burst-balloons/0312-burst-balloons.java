class Solution {
    public int maxCoins(int[] nums) {
        int m = nums.length;
        int[] arr = new int[m+2];
        arr[0] = 1;
        arr[m+1] = 1;
        
        for(int i = 0;i<m;i++){
            arr[i+1] = nums[i];
        }
        int[][] dp = new int[m+2][m+2];

        for(int[] row : dp ){
            Arrays.fill(row,-1);
        }
        return solve(1,m,arr,dp);

    }
    public int solve(int i,int j,int[] arr,int[][] dp){
        if(i>j){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int ans =0;

        for(int k =i;k<=j;k++){
            int coins = solve(i,k-1,arr,dp)+solve(k+1,j,arr,dp)+arr[i-1]*arr[k]*arr[j+1];

            ans = Math.max(ans,coins);
        }
        return dp[i][j] = ans;
    }
}