class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum =0;
        for(int num : nums){
            sum += num;
        }
        if(sum%2 != 0){
            return false;
        }
        int target  = sum / 2;

        int[][] dp = new int[n][target+1];

        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return solve(0,target,nums,dp);
    }
    public boolean solve(int i,int target,int[] nums,int[][] dp){
        if(target == 0){
            return true;
        }
        if(i == nums.length){
            return false;
        }
        if(dp[i][target] != -1){
            return dp[i][target] == 1;
        }
        boolean notTake = solve(i+1,target,nums,dp);

        boolean take = false;

        if(nums[i] <= target){
            take = solve(i+1,target-nums[i], nums,dp);
            }
            boolean result = take || notTake;

            dp[i][target] = result ? 1 : 0;
            return result;
        }
}