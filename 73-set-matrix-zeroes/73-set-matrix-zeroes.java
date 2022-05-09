class Solution {

    public void makeZero(int[][] M, int row, int col) {
        // makes row and column 0
        for (int j = 0; j < M[0].length; j++) {
            M[row][j] = 0;
        }

        for (int i = 0; i < M.length; i++) {
            M[i][col] = 0;
        }
    }

    public void setZeroes(int[][] M) {
        int m = M.length;
        int n = M[0].length;

        int[][] temp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = M[i][j];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (M[i][j] == 0) {
                    makeZero(temp, i, j);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                M[i][j] = temp[i][j];
            }
        }
    }
}
