class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];

        int maxArea = 0;
        for(int i =0; i< rows; i++){
            for(int j =0; j< cols; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    int area = bfs(i,j,grid,visited);
                    maxArea= Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }
    private int bfs(int row, int col, int[][] grid, boolean[][] visited){
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{row,col});
        visited[row][col] = true;

        int area =1;

        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};

        while(!q.isEmpty()){
            int[] cell = q.poll();

            int currentRow = cell[0];
            int currentCol = cell[1];

            for(int k =0; k< 4; k++){
                int newRow = currentRow + dr[k];
                int newCol = currentCol + dc[k];

                 if (newRow >= 0 &&
                    newRow < grid.length &&
                    newCol >= 0 &&
                    newCol < grid[0].length &&
                    grid[newRow][newCol] == 1 &&
                    !visited[newRow][newCol]){
                    visited[newRow][newCol] = true;
                    area++;

                    q.offer(new int[]{newRow, newCol});
                }
            }
        }
        return area;
    }
}