class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int currentMax = nums[0];
        int maxSum = nums[0];

        int currentMin = nums[0];
        int minSum = nums[0];

        for(int i = 1; i < nums.length; i++){
            currentMax = Math.max(nums[i], nums[i]+ currentMax);
            maxSum = Math.max(currentMax,maxSum);

            currentMin = Math.min(nums[i], nums[i] + currentMin);
            minSum = Math.min(currentMin, minSum);
        }
        return Math.max(maxSum,-minSum);
    }

}