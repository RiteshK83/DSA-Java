import java.util.*;

class Solution {

    public int numIslands(char[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];

        int island = 0;

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == '1' && !visited[i][j]) {

                    island++;

                    bfs(i, j, grid, visited);
                }
            }
        }

        return island;
    }

    private void bfs(int row, int col, char[][] grid, boolean[][] visited) {

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{row, col});
        visited[row][col] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!q.isEmpty()) {

            int[] cell = q.poll();

            int currentRow = cell[0];
            int currentCol = cell[1];

            for (int k = 0; k < 4; k++) {

                int newRow = currentRow + dr[k];
                int newCol = currentCol + dc[k];

                if (newRow >= 0 &&
                    newRow < grid.length &&
                    newCol >= 0 &&
                    newCol < grid[0].length &&
                    grid[newRow][newCol] == '1' &&
                    !visited[newRow][newCol]) {

                    visited[newRow][newCol] = true;

                    q.offer(new int[]{newRow, newCol});
                }
            }
        }
    }
}