class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int[][] dp = new int[s1.length()][s2.length()];

        for(int[] row : dp){
            Arrays.fill(row,-1);

        }
        return solve(0,0,s1,s2,dp);
    }
    public int solve(int i,int j,String s1,String s2,int[][] dp){
        if(i == s1.length()){
            int sum =0;
            while(j<s2.length()){
                sum += s2.charAt(j);
                j++;
            }
            return sum;
        }
        if(j == s2.length()){
            int sum =0;
            while(i<s1.length()){
                sum += s1.charAt(i);
                i++; 
            }
            return sum;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = solve(i+1,j+1,s1,s2,dp);
        }
        int deleteS1 = s1.charAt(i) + solve(i+1,j,s1,s2,dp);
        int deleteS2 = s2.charAt(j) + solve(i,j+1,s1,s2,dp);

        return dp[i][j] = Math.min(deleteS1,deleteS2);
    }
}