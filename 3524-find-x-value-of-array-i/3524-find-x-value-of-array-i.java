class Solution {
    public long[] resultArray(int[] nums, int k) {

        long[] result = new long[k];
        long[] dp = new long[k];

        for (int num : nums) {

            int value = num % k;

            long[] newDp = new long[k];

           
            newDp[value]++;

            for (int r = 0; r < k; r++) {

                if (dp[r] == 0) {
                    continue;
                }

                int newRemainder = (r * value) % k;

                newDp[newRemainder] += dp[r];
            }

           
            dp = newDp;

           
            for (int r = 0; r < k; r++) {
                result[r] += dp[r];
            }
        }

        return result;
    }
}