class Solution {
    public int distinctSubseqII(String s) {
        long dp = 0;
        long[] last = new long[26];
        long MOD =  1000000007;

        for(char c : s.toCharArray()){
            int index = c - 'a';

            long newDp = (2*dp+1-last[index]+ MOD) % MOD;

            last[index] = dp+1;
            dp = newDp;
        }
        return (int) dp;
    }
}