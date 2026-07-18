class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        if(originalColor == color){
            return image;
        }
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{sr,sc});
        image[sr][sc] = color;

        while(!q.isEmpty()){
            int[] cell = q.poll();

            int row = cell[0];
            int col = cell[1];

            for(int k=0; k<4; k++){
                int newRow = row + dr[k];
                int newCol = col + dc[k];

                if(newRow >= 0 && newRow < image.length && newCol >= 0 && newCol < image[0].length && image[newRow][newCol] == originalColor){
                    image[newRow][newCol] = color;
                    q.offer(new int[]{newRow,newCol});
                } 
            }
        }
        return image;
    }
}