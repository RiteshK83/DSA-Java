class Solution {
    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return solve(0,s,dp);
    }
    public int solve(int i ,String s, int[] dp){
        if(i == s.length()){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        int ans = Integer.MAX_VALUE;

        for(int j=i;j<s.length();j++){
            if(isPalindrome(s,i,j)){
                if(j == s.length() -1){
                    ans =0;
                }
                else {
                    int cuts = 1 + solve(j+1,s,dp);
                    ans =Math.min(ans,cuts);
                }
            }
        }
        return dp[i] = ans;
    }
    public boolean isPalindrome(String s,int i,int j){
        while(i<j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}