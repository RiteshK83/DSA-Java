class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Integer>[] rows = new HashSet[9];
        HashSet<Integer>[] cols = new HashSet[9];
        HashSet<Integer>[] boxes = new HashSet[9];

        for(int i = 0; i< 9; i++){
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }
        for(int r =0; r < 9; r++){
            for(int c =0; c<9; c++){
                char ch = board[r][c];

                if(ch == '.'){
                    continue;
                }
                int num = ch - '0';

                int box = (r/3)*3+(c/3);

                if(rows[r].contains(num) || cols[c].contains(num) || boxes[box].contains(num)){
                    return false;
                }
                rows[r].add(num);
                cols[c].add(num);
                boxes[box].add(num);
            }
        }
        return true;

    }
}