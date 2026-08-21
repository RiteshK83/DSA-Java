class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        int maxSum =0;

        for(int i =0; i<k; i++){
            sum += nums[i];
           
        }
         maxSum = sum;

        for(int i =k; i<nums.length;i++){
            sum = sum - nums[i-k] + nums[i];
            maxSum = Math.max(maxSum,sum);
        }
        return (double) maxSum/k;
    }
}