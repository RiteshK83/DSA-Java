class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        int fresh = 0;
        int minutes =0;

        for(int i =0; i< rows; i++){
            for(int j =0; j< cols; j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i,j});
                }
                else if(grid[i][j] == 2){
                    q.offer(new int[]{i,j});
                }
                else if (grid[i][j]==1){
                    fresh++;
                }
            }
        }
        if(fresh ==0){
            return 0;
        }
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};

        while(!q.isEmpty() && fresh > 0){
            int size = q.size();

            for(int i =0; i< size; i++){
                int[] cell = q.poll();

                int row = cell[0];
                int col = cell[1];

                for(int k =0; k< 4; k++){
                    int newRow = row + dr[k];
                    int newCol = col + dc[k];


                    if(newRow >= 0 && newRow < rows && newCol >=0 && newCol < cols &&  grid[newRow][newCol] == 1){
                        grid[newRow][newCol] = 2;
                        fresh--;

                        q.offer(new int[]{newRow, newCol});
                    }
                }
            }
            minutes++;
        }
        return (fresh ==0) ? minutes : -1;
    }
}