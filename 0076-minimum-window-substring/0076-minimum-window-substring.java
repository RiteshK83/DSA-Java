class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()){
            return "";
        }
        HashMap<Character, Integer> need = new HashMap<>();
        for(char ch : t.toCharArray()){
            need.put(ch,need.getOrDefault(ch,0)+1);
        } 
        HashMap<Character,Integer> window = new HashMap<>();

        int left =0;
        int right =0;
        int have =0;
        int needCount = need.size();

        int minLength = Integer.MAX_VALUE;
        int start = 0;

        while(right < s.length()){
            char ch = s.charAt(right);

            window.put(ch,window.getOrDefault(ch,0)+1);

            if(need.containsKey(ch) && window.get(ch).equals(need.get(ch))){
                have++;
            }
            while(have == needCount){
                int currentLength = right - left +1;

                if(currentLength < minLength){
                    minLength = currentLength;

                    start = left;
                }
                char leftChar = s.charAt(left);

                window.put(leftChar,window.get(leftChar) -1);

                if(need.containsKey(leftChar) && window.get(leftChar) < need.get(leftChar)){
                    have--;
                }
                left++;
            }
            right++;
        }   
        if(minLength == Integer.MAX_VALUE){
            return "";
        }
        return s.substring(start,start + minLength);
        }
}