import java.util.Arrays;

class Solution {

    int n;
    int[] prefixSum;
    int[] dp;

    int solve(int i) {

        if (i == n - 1) {
            return prefixSum[n - 1];
        }

        if (dp[i] != Integer.MIN_VALUE) {
            return dp[i];
        }

        int take = prefixSum[i] - solve(i + 1);

        int skip = solve(i + 1);

        return dp[i] = Math.max(take, skip);
    }

    public int stoneGameVIII(int[] stones) {

        n = stones.length;

        prefixSum = new int[n];
        dp = new int[n];

        prefixSum[0] = stones[0];

        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + stones[i];
        }

        Arrays.fill(dp, Integer.MIN_VALUE);

        return solve(1);
    }
}