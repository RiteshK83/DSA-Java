class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n-1][n-1]==1){
            return -1;
        }
        int[] dr = {-1,-1,-1,0,0,1,1,1};
        int[] dc = {-1,0,1,-1,1,-1,0,1};

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0,1});
        grid[0][0] = 1;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int row = curr[0];
            int col = curr[1];
            int path = curr[2];

            if(row == n-1 && col == n-1){
                return path;
            }
            for(int k =0; k<8; k++){
                int newRow = row + dr[k];
                int newCol = col + dc[k];

                if(newRow >=0 && newRow < n && newCol >= 0 && newCol < n && grid[newRow][newCol] ==0){
                grid[newRow][newCol] = 1;
                q.offer(new int[]{newRow,newCol,path+1});
                }
            }

        }
        return -1;
    }
}