class Solution {
    public String reverseVowels(String s) {

        char[] arr = s.toCharArray();
        int i =0;
        int j = arr.length-1;

        while(i<j){
            if(!isVowel(arr[i])){
                i++;
            }
            else if(!isVowel(arr[j])){
                j--;
            }
            else{
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
        
            }
        }

        return new String(arr);
    }
    private boolean isVowel(char ch){
            if(Character.toLowerCase(ch)=='a' || Character.toLowerCase(ch) == 'e' || Character.toLowerCase(ch) == 'i' || Character.toLowerCase(ch) == 'o' || Character.toLowerCase(ch) == 'u'){
                return true;
            }
            else{
                return false;
            }
        }
}