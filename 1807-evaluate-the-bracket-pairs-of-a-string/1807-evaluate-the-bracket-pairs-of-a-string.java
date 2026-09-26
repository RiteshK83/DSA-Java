class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String,String> map = new HashMap<>();

        for(List<String> pair : knowledge){
            map.put(pair.get(0), pair.get(1));
        }
        StringBuilder ans = new StringBuilder();

        int i =0;

        while(i< s.length()){
            if(s.charAt(i) != '('){
                ans.append(s.charAt(i));
                i++;
            }
            else{
                i++;

                StringBuilder key = new StringBuilder();

                while(s.charAt(i) != ')'){
                    key.append(s.charAt(i));
                    i++;
                }
                i++;

                String value = map.get(key.toString());

                if(value != null){
                    ans.append(value);

                }
                else{
                    ans.append('?');
                }
            }
        }
        return ans.toString();
    }
}