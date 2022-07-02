class Solution {
    private static boolean flag;
    
    public void solveSudoku(char[][] board) {
        flag = false;
        solve(board, 0, 0);
        
    }
    
    private void solve(char[][] board, int row, int col) {
        
        if(row == 9) {
            flag = true;
            return;
        }
        
        int nrow = col == 8 ? row + 1 : row;
        int ncol = col == 8 ? 0 : col + 1;
        
        if(board[row][col] != '.') {
            solve(board, nrow, ncol);
        } else {
            for(char o = '1'; o <= '9'; o++) {
                if(isValid(board, row, col, o)) {
                    board[row][col] = o;
                    solve(board, nrow, ncol);
                    if(flag == false) {
                    board[row][col] = '.';
                    }
                }
            }
        }
    }

    private static boolean isValid(char[][] board, int row, int col, char value) {
        // row and column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == value) {
                return false;
            }
            if (board[row][i] == value) {
                return false;
            }
        }

        // subgrid
        int rs = (row / 3) * 3;
        int cs = (col / 3) * 3;

        for (int i = rs; i < rs + 3; i++) {
            for (int j = cs; j < cs + 3; j++) {
                if (board[i][j] == value) {
                    return false;
                }
            }
        }

        return true;
    }
}
