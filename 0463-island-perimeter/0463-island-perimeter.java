class Solution {
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int perimeter = 0;

        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};

        for(int i =0; i<rows; i++){
            for(int j=0; j< cols; j++){
                if(grid[i][j] == 1){
                    perimeter += 4;

                    for(int k =0; k<4; k++){
                        int newRow = i +dr[k];
                        int newCol = j+ dc[k];

                        if(newRow >=0 &&newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == 1){
                            perimeter--;
                        }
                    }                }
            }
        }
        return perimeter;
    }
}