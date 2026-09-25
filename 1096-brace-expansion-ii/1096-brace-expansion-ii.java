class Solution {

    String s;
    int index;

    public List<String> braceExpansionII(String expression) {
        s = expression;
        index = 0;

        Set<String> result = parseExpression();

        List<String> ans = new ArrayList<>(result);
        Collections.sort(ans);

        return ans;
    }

    // Handles UNION: A,B,C
    Set<String> parseExpression() {

        Set<String> result = parseSequence();

        while (index < s.length() && s.charAt(index) == ',') {

            index++; // skip ','

            Set<String> next = parseSequence();

            result.addAll(next);
        }

        return result;
    }

    // Handles CONCATENATION: AB{c,d}ef
    Set<String> parseSequence() {

        Set<String> result = new HashSet<>();
        result.add("");

        while (index < s.length()
                && s.charAt(index) != ','
                && s.charAt(index) != '}') {

            Set<String> next;

            char ch = s.charAt(index);

            if (ch == '{') {

                index++; // skip '{'

                next = parseExpression();

                index++; // skip '}'

            } else {

                next = new HashSet<>();
                next.add(String.valueOf(ch));

                index++;
            }

            result = combine(result, next);
        }

        return result;
    }

    // Cartesian product
    Set<String> combine(Set<String> a, Set<String> b) {

        Set<String> result = new HashSet<>();

        for (String x : a) {
            for (String y : b) {
                result.add(x + y);
            }
        }

        return result;
    }
}