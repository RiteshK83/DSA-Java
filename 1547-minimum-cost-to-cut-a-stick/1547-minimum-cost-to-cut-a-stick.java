class Solution {
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        
        Arrays.sort(cuts);

        int[] arr = new int[m+2];

        arr[0] = 0;
        arr[m+1] = n;

        for(int i =0; i< m;i++){
            arr[i+1] = cuts[i];
        }
        int[][] dp = new int[m+2][m+2];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return solve(0,m+1,arr,dp);
    }
    public int solve(int i,int j, int[] arr, int[][] dp){
        if(j-i == 1){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int ans = Integer.MAX_VALUE;
        for(int k = i+1;k<j;k++){
            int left = solve(i,k,arr,dp);
            int right = solve(k,j,arr,dp);
            int currCost = arr[j] - arr[i];

            int cost = left+right+currCost;
            ans = Math.min(ans,cost);
        }
        return dp[i][j] = ans;
    }
}