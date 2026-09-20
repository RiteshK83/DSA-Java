class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        

        for(int i =0;i<intervals.length;i++){
            int start = intervals[i][0];
            int end = intervals[i][1];


            if(end < newInterval[0]){
                result.add(intervals[i]);
            }
            else if(start > newInterval[1]){
                result.add(newInterval);

                result.add(intervals[i]);
                for(int j =i+1; j< intervals.length;j++){
                    result.add(intervals[j]);
                }
                return result.toArray(new int[result.size()][]);
            }
            else{
                newInterval[0] = Math.min(newInterval[0], start);
                newInterval[1] = Math.max(newInterval[1], end);
            }
        }
        result.add(newInterval);
        return result.toArray(new int[result.size()][]);
    }
}