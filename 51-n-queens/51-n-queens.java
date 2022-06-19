class Solution {
    
    public boolean isSafe(int[][] board, int row, int col) {
        
        //vertical column
        for(int i = row - 1; i >= 0; i--) {
            if(board[i][col] == 1) {
                return false;
            }
        }
        
        //left diagonal
        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if(board[i][j] == 1) {
                return false;
            }
        }
        
        //right diagonal
        for(int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if(board[i][j] == 1) {
                return false;
            }
        }
        
        return true;
    }
    
    public void solve(int[][] board, int row, List<List<String>> res) {
        
        if(row == board.length) {
            List<String> temp = new ArrayList<>();
            for(int[] list : board) {
                String s = "";
                for(int el : list) {
                    if(el == 1) {
                        s += "Q";
                    } else {
                        s += ".";
                    }
                }
                temp.add(s);
            }
            res.add(temp);
            return;
        }
        
        
        //we need to place queen on rowth row
        for(int i = 0; i < board.length; i++) {
            if(isSafe(board, row, i)) {
                board[row][i] = 1;
                solve(board, row + 1, res);
                board[row][i] = 0;
            }
        }
        
    }
    
    public List<List<String>> solveNQueens(int n) {
        
        int[][] board = new int[n][n];
        List<List<String>> res = new ArrayList<>();
        solve(board, 0, res);
        return res;
    }
}