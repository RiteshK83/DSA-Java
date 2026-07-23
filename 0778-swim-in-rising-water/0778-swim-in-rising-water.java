class Solution {
    class Pair {
        int row;
        int col;
        int time;
        Pair(int row, int col , int time){
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] distance = new int[n][n];

        for(int[] row : distance){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        distance[0][0] = grid[0][0];

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.time,b.time));
        pq.offer(new Pair(0, 0, grid[0][0]));

        int[] dr = {-1,1,0,0};
        int[] dc= {0,0,-1,1};

        while(!pq.isEmpty()){
            Pair current = pq.poll();

            int row = current.row;
            int col = current.col;
            int time = current.time;

            if(time > distance[row][col]){
                continue;
            }
            if(row == n-1 && col == n-1){
                return time; 
               }

            for(int i=0; i< 4; i++){
                int newRow = row + dr[i];
                int newCol = col + dc[i];

            if (newRow < 0 || newRow >= n || newCol < 0 || newCol >= n) {
                continue;
               }
               int newTime = Math.max(time, grid[newRow][newCol]);

               if(newTime < distance[newRow][newCol]){
                distance[newRow][newCol] = newTime;
                pq.offer(new Pair(newRow,newCol,newTime));
               }
        
            }
        }
        return -1;
    }
}