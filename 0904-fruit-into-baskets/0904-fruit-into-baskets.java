class Solution {
    public int totalFruit(int[] fruits) {
        int left =0;
        int maxLen =0;

        HashMap <Integer,Integer> map = new HashMap<>();

        for(int right = 0; right<fruits.length; right++){
            int fruit = fruits[right];

            map.put(fruit,map.getOrDefault(fruit,0)+1);

            while(map.size()> 2){
                int leftfruit = fruits[left];
                map.put(leftfruit,map.get(leftfruit)-1);
                if(map.get(leftfruit)==0){
                    map.remove(leftfruit);
                }
                left++;
               
            }
            maxLen = Math.max(maxLen,right-left+1);

        
        }
        return maxLen;
    }
}