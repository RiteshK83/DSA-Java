class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n-1][n-1];
        
        while(left < right){
            int mid = left + (right - left)/2;
            int count = 0;

            for(int[] row : matrix){
                int l =0;
                int r = n;

                while(l<r){
                    int m = l + (r-l)/2;
                    if(row[m] <= mid){
                        l = m+1;

                    }
                    else {
                        r = m;
                    }


                }
                count +=l;
            }
            if(count<k){
                left = mid+1;
            }
            else {
                right = mid;
            }
        }
        return left;
    }
}