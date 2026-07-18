class Solution {
    public int numEnclaves(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        for(int  i=0; i < rows; i++){
            if(grid[i][0] == 1){
                dfs(i,0,grid);
            }
            if(grid[i][cols-1]==1){
                dfs(i,cols-1,grid);
            }
        }
        for(int j=0; j< cols; j++){
            if(grid[0][j] ==1){
                dfs(0,j,grid);
            }
            if(grid[rows-1][j] ==1){
                dfs(rows-1,j,grid);
            }
        }
        int count = 0;
        for(int i =0; i< rows; i++){
            for(int j =0; j< cols; j++){
                if(grid[i][j] == 1){
                    count ++;
                }
            }
            
        }
        return count;
    }
        private void dfs(int row, int col, int[][] grid){
            if(row <0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0 ){
                return;
            }
            grid[row][col] =0;

           dfs(row - 1, col, grid);
           dfs(row + 1, col, grid);
           dfs(row, col - 1, grid);
           dfs(row, col + 1, grid); 
        }
    }
