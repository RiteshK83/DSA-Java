class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int currentEnd = points[0][1];

        int arrows = 1;

        for(int i =1; i< points.length; i++){
            int start = points[i][0];
            int end = points[i][1];

            if(start <= currentEnd){
                currentEnd = Math.min(currentEnd, end);
            }
            else {
                arrows++;
                currentEnd = end;
            }
        }
        return arrows;
    }
}