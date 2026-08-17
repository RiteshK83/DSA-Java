class Solution {

    public int cherryPickup(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[][][] dp = new int[m][n][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return solve(0, 0, n - 1, grid, dp);
    }

    public int solve(int row, int col1, int col2,
                     int[][] grid, int[][][] dp) {

        if (dp[row][col1][col2] != -1) {
            return dp[row][col1][col2];
        }

        int current;

        if (col1 == col2) {
            current = grid[row][col1];
        } else {
            current = grid[row][col1] + grid[row][col2];
        }

        if (row == grid.length - 1) {
            return dp[row][col1][col2] = current;
        }

        int best = 0;

        for (int move1 = -1; move1 <= 1; move1++) {
            for (int move2 = -1; move2 <= 1; move2++) {

                int newCol1 = col1 + move1;
                int newCol2 = col2 + move2;

                if (newCol1 < 0 || newCol1 >= grid[0].length ||
                    newCol2 < 0 || newCol2 >= grid[0].length) {
                    continue;
                }

                best = Math.max(
                    best,
                    solve(row + 1, newCol1, newCol2, grid, dp)
                );
            }
        }

        return dp[row][col1][col2] = current + best;
    }
}