class Solution {
    
    private static int total_solutions;

    public boolean isSafe(int[][] board, int row, int col) {
        //vertical column
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 1) {
                return false;
            }
        }

        //left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        //right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

     public void solve(int[][] board, int row) {
        
        if(row == board.length) {
            total_solutions++;
            return;
        }
        
        
        //we need to place queen on rowth row
        for(int i = 0; i < board.length; i++) {
            if(isSafe(board, row, i)) {
                board[row][i] = 1;
                solve(board, row + 1);
                board[row][i] = 0;
            }
        }
     }
        
    public int totalNQueens(int n) {
        total_solutions = 0;
        int[][] board = new int[n][n];
        int res = 0;
        solve(board, 0);
        return total_solutions;
    }
}
