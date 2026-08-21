class Solution {
    public List<Integer> findAnagrams(String s, String p) {
       List<Integer> result = new ArrayList<>();

       int[] pFreq = new int[26];
       int[] windowFreq = new int[26];

       for(int i =0; i< p.length(); i++){
        pFreq[p.charAt(i) - 'a']++;
       } 
       if(p.length() > s.length()){
        return result;
       }
       for(int i =0; i< p.length(); i++){
        windowFreq[s.charAt(i) - 'a']++;
       }
       if(Arrays.equals(pFreq,windowFreq)){
        result.add(0);
       }
       for(int i = p.length(); i< s.length(); i++){
        windowFreq[s.charAt(i-p.length()) - 'a']--;
        windowFreq[s.charAt(i)- 'a']++;

        if(Arrays.equals(pFreq,windowFreq)){
            result.add(i-p.length() +1);
        }

       }
       return result;
    }
}