class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> {
            if(a[0] == b[0]){
                return Integer.compare(b[1],a[1]);
            }
            return Integer.compare(a[0],b[0]);
        });
        int count = 0;
        int currentEnd = intervals[0][1];

        for(int i =1; i< intervals.length; i++){
            int nextEnd = intervals[i][1];

            if(nextEnd <= currentEnd){
                count++;
            }
            else {
                currentEnd = Math.max(currentEnd,nextEnd);
            }
        }
        return intervals.length -  count;
    }
}