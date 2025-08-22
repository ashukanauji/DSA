class Solution {
    public void dfs(int sr, int sc, int color, int[][] image, int[][] vis, int toColor){
        int m = image.length;
        int n = image[0].length;
        int[] dRow = {0, -1, 0, 1};
        int[] dCol = {1, 0, -1, 0};
        vis[sr][sc] = color;

        for(int i = 0; i < 4; i++){
            int nRow = sr + dRow[i];
            int nCol = sc + dCol[i];
            if(nRow >=0 && nRow < m && nCol < n && nCol >= 0 && vis[nRow][nCol] != color && image[nRow][nCol] == toColor){
                // vis[nRow][nCol] = color;
                dfs(nRow, nCol, color, image, vis, toColor);
            }
        }

        return;
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        int toColor = image[sr][sc];

        int[][] vis = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                // if(image[i][j] != color)
                vis[i][j] = image[i][j];
            }
        }
        
        dfs(sr, sc, color, image, vis, toColor);
  
        return vis;
        
    }
}