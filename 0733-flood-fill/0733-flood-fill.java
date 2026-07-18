class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        // BFS Method
        // int originalColor = image[sr][sc];
        // if(originalColor == color){
        //     return image;
        // }
        // int[] dr = {-1,1,0,0};
        // int[] dc = {0,0,-1,1};

        // Queue<int[]> q = new LinkedList<>();

        // q.offer(new int[]{sr,sc});
        // image[sr][sc] = color;

        // while(!q.isEmpty()){
        //     int[] cell = q.poll();

        //     int row = cell[0];
        //     int col = cell[1];

        //     for(int k=0; k<4; k++){
        //         int newRow = row + dr[k];
        //         int newCol = col + dc[k];

        //         if(newRow >= 0 && newRow < image.length && newCol >= 0 && newCol < image[0].length && image[newRow][newCol] == originalColor){
        //             image[newRow][newCol] = color;
        //             q.offer(new int[]{newRow,newCol});
        //         } 
        //     }
        // }
        // return image;
        int oldColor = image[sr][sc];

        if(oldColor == color){
            return image;
        }
        dfs(sr,sc,image,oldColor,color);
        return image;
    }
    private void dfs(int row, int col, int[][] image, int oldColor, int color){
        if (row < 0 ||
            row >= image.length ||
            col < 0 ||
            col >= image[0].length ||
            image[row][col] != oldColor) {

            return;
        }
        image[row][col] = color;

        dfs(row-1, col, image, oldColor,color);
        dfs(row + 1, col, image, oldColor, color);
        dfs(row, col - 1, image, oldColor, color);
        dfs(row, col + 1, image, oldColor, color);

        
    }
}