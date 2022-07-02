class Solution {

    public boolean exist(char[][] board, String word) {
        // if(board[])
        char fc = word.charAt(0);
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == fc) {
                    boolean res = solve(board, i, j, 0, word, visited);
                    if (res) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean solve(char[][] board, int row, int col, int index, String target, boolean[][] visited) {

        if(index == target.length()) {
            return true;
        }
         else if (row < 0 || col < 0 || row == board.length || col == board[0].length || visited[row][col] == true || board[row][col] != target.charAt(index)) {
            return false;
        }

        visited[row][col] = true;

        // move to top
        boolean op1 = solve(board, row - 1, col, index + 1, target, visited);

        // move to right
        boolean op2 = solve(board, row, col + 1, index + 1, target, visited);

        // move to bottom
        boolean op3 = solve(board, row + 1, col, index + 1, target, visited);

        // move to left
        boolean op4 = solve(board, row, col - 1, index  + 1, target, visited);

        visited[row][col] = false;

        return op1 || op2 || op3 || op4;
    }
}
