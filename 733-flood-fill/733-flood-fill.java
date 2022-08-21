class Solution {

    static void dfs(int[][] image, int sr, int sc, int color, boolean[][] visited, int scolor) {
        if (sr < 0 || sc < 0 || sr == image.length || sc == image[0].length || visited[sr][sc] == true || image[sr][sc] != scolor) {
            return;
        }

        image[sr][sc] = color;
        visited[sr][sc] = true;

        int[] xcoord = { -1, 0, 1, 0 };
        int[] ycoord = { 0, 1, 0, -1 };

        for (int i = 0; i < 4; i++) {
            int x = xcoord[i];
            int y = ycoord[i];
            dfs(image, sr + x, sc + y, color, visited, scolor);
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        int m = image.length;
        int n = image[0].length;
        
        dfs(image, sr, sc, color, new boolean[m][n], image[sr][sc]);
        
        return image;
        
    }
}
