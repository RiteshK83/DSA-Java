import java.util.*;

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();

        if (digits.isEmpty()) {
            return ans;
        }

        String[] map = {
            "", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        helper(0, digits, new StringBuilder(), ans, map);

        return ans;
    }

    private void helper(int index, String digits,
                        StringBuilder current,
                        List<String> ans, String[] map) {

        if (index == digits.length()) {
            ans.add(current.toString());
            return;
        }

        String letters = map[digits.charAt(index) - '0'];

        for (int i = 0; i < letters.length(); i++) {
            current.append(letters.charAt(i));

            helper(index + 1, digits, current, ans, map);

            current.deleteCharAt(current.length() - 1);
        }
    }
}