class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n==1){
            return nums[0];
        }
        int case1 = robHelper(nums,0,n-2);
        int case2 = robHelper(nums,1,n-1);

        return Math.max(case1,case2);
    }
    private int robHelper(int[] nums, int start,int end){
        int prev2 = 0;
        int prev1 = 0;

        for(int i =start;i<=end; i++){
            int pick = nums[i] + prev2;
            int notPick = prev1;

            int current = Math.max(pick,notPick);
            prev2 = prev1; 
            prev1 = current;
        }
        return prev1;
    }
}