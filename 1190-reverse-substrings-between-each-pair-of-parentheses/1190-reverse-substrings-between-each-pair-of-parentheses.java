class Solution {
    public String reverseParentheses(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder current = new StringBuilder();

        for(int i =0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '('){
                stack.push(current.toString());
                current = new StringBuilder();
            }
            else if(ch== ')'){
                current.reverse();

                String previous = stack.pop();

                current = new StringBuilder(previous + current);
            }
            else {
                current.append(ch);
            }
        }
        return current.toString();
    }
}