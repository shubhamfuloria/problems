class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] == '.') {
                    continue;
                } else {
                    if(isValid(board, i, j, board[i][j]) == false) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
      private static boolean isValid(char[][] board, int row, int col, char value) {
        // row and column
        for (int i = 0; i < 9; i++) {
            if (i != row && board[i][col] == value) {
                return false;
            }
            if (col != i && board[row][i] == value) {
                return false;
            }
        }

        // subgrid
        int rs = (row / 3) * 3;
        int cs = (col / 3) * 3;

        for (int i = rs; i < rs + 3; i++) {
            for (int j = cs; j < cs + 3; j++) {
                if ((i != row && j != col) && board[i][j] == value) {
                    return false;
                }
            }
        }

        return true;
    }
}