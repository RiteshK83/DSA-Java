class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        int[][] distance  = new int [rows][cols];
        boolean[][] visited = new boolean[rows][cols];

        Queue<int[]> q = new LinkedList<>();

        for(int i =0; i< rows; i++){
            for(int j =0; j < cols; j++){
                if(mat[i][j] == 0){
                    q.offer(new int[]{i,j});
                    visited[i][j] =true;
                }
            }
        }
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        while(!q.isEmpty()){
            int[] cell = q.poll();
            int currRow = cell[0];
            int currCol = cell[1];

        for(int k =0; k< 4; k++){
            int newRow = currRow + dr[k];
            int newCol = currCol + dc[k];

            if(newRow >= 0 && newRow < rows && newCol >=0 && newCol < cols && !visited[newRow][newCol]){
                visited[newRow][newCol] = true;
                distance[newRow][newCol] = distance[currRow][currCol] +1;

                q.offer(new int[]{newRow,newCol});
            }
        }
        }
        return distance;
    }
}