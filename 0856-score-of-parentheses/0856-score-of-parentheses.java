class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for(int i =0; i< s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '('){
                stack.push(0);
            }
            else {
                int inner = stack.pop();

                if(inner == 0){
                    inner = 1;
                }
                else {
                    inner = 2 * inner;
                }
                int parent = stack.pop();
                stack.push(parent + inner);
            }
        }
        return stack.peek();
    }
}