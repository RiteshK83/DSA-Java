class Solution {
    public int totalNumbers(int[] digits) {
        int[] freq = new int[10];
        for(int digit : digits){
            freq[digit]++;
        }
        int ans = 0;

        for(int i =1; i<=9; i++){
            for(int j = 0;j<=9; j++){
                for(int k=0; k<=8; k+=2){
                    if(i==j && j==k){
                        if(freq[i] >= 3){
                            ans++;
                        }
                    }
                    else if(i==j){
                        if(freq[i] >= 2 && freq[k] >= 1){
                            ans++;
                        }
                    }
                    else if(i==k){
                        if(freq[i] >=2 && freq[j] >=1){
                            ans++;
                        }
                    }
                    else if(j==k){
                        if(freq[j] >= 2 && freq[i] >= 1){
                            ans++;
                        }
                    }
                    else {
                        if(freq[i] >= 1 && freq[j] >= 1 && freq[k] >=1){
                            ans++;
                        }
                    }
                }
            }
        }
        return ans;
    }
}