class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> st = new Stack<>();

        for(int i =0; i< n; i++){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                left[i] = -1;
            }
            else{
                left[i] = st.peek();
            }
            st.push(i);
        }
        st.clear();

        for(int i = n-1; i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()] >arr[i] ){
                st.pop();
            }
            if(st.isEmpty()){
                right[i] = n;
            }
            else{
                right[i] = st.peek();
            }
            st.push(i);
        }
        long ans = 0;
        int MOD = 1_000_000_007;
        for(int i =0; i<n ; i++){
            long leftChoices = i - left[i];
            long rightChoices = right[i] - i;


            long contribution = arr[i] * leftChoices * rightChoices;

            ans = (ans + contribution) % MOD;
        }
        return (int) ans;
    }
}