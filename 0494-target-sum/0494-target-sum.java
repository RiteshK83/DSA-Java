class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int total = 0;
        for(int num : nums){
            total += num;
        }
        if(Math.abs(target) > total){
            return 0;
        }
        int[][] dp = new int[n][2*total +1];

        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return solve(0,0,nums,target,total,dp);
    }
    public int solve(int i,int sum,int[] nums,int target,int total,int[][] dp){
        if(i == nums.length){
            if(sum == target){
                return 1;
            }
            return 0;
        }
        int index = sum + total;
        if(dp[i][index] != -1){
            return dp[i][index];
        }
        int plus = solve(i+1,sum+nums[i],nums,target,total,dp);
        int minus = solve(i+1,sum-nums[i],nums,target,total,dp);
        int ways = plus + minus;

        dp[i][index] = ways;
        return ways;
    }
}