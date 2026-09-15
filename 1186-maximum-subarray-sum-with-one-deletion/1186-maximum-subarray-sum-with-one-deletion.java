class Solution {
    public int maximumSum(int[] arr) {
        long noDelete = arr[0];
        long oneDelete = Integer.MIN_VALUE;

        long ans = arr[0];

        for(int i =1; i< arr.length; i++){
            long previousNoDelete = noDelete;
            long previousOneDelete = oneDelete;

            noDelete = Math.max(arr[i], previousNoDelete+arr[i]);
            oneDelete = Math.max(previousOneDelete + arr[i], previousNoDelete);

            ans = Math.max(ans,Math.max(noDelete,oneDelete));
        }
        return (int) ans;
    }
}