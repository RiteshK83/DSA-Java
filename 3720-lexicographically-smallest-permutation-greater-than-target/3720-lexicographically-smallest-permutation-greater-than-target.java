class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] freq = new int[26];

        for(char ch : s.toCharArray()){
            freq[ch-'a']++;
        }
        char[] ans = target.toCharArray();

        for(int i =0; i<n;i++){
            int ch = target.charAt(i) - 'a';

            if(freq[ch] > 0){
                freq[ch]--;
            }
            else {
                for(int j =i; j>=0; j--){
                    if(j<i){
                    int original = target.charAt(j) - 'a';
                    freq[original]++;
                    }
                     int original = target.charAt(j) - 'a';


                    for(int k = original+1; k<26; k++){
                        if(freq[k] >0){
                            ans[j] = (char) ('a' + k);
                            freq[k]--;

                            int pos = j+1;
                            for(int c =0; c<26; c++){
                                while(freq[c] >0){
                                    ans[pos++] = (char) ('a' + c);
                                    freq[c]--;
                                }
                            }
                            return new String(ans);
                        }
                    }
                }
                return "";
            }
            ans[i] = target.charAt(i);
        }
        for(int i = n-1; i>=0;i--){
            int original = target.charAt(i) - 'a';
            freq[original]++;
            for(int k = original+1; k<26;k++){
                if(freq[k] > 0){
                    ans[i] = (char) ('a' + k);
                    freq[k]--;

                
                    int pos = i + 1;

                    for (int c = 0; c < 26; c++) {
                        while (freq[c] > 0) {
                            ans[pos++] = (char) ('a' + c);
                            freq[c]--;
                        }
                    }
                    return new String(ans);
                }
            }
        }
        return "";
    }
}