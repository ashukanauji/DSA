class Solution {
    private static void dfs(int[][] grid, boolean[][] vis, int row, int col){
        int m = grid.length, n = grid[0].length;

        vis[row][col] = true;
         

        int[] dRow = {0, 1, 0, -1};
        int[] dCol = {1, 0, -1, 0};

        for(int i = 0; i < 4; i++){
            int newRow = row + dRow[i];
            int newCol = col + dCol[i];

            if(newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol] == 1 && vis[newRow][newCol] == false ){
                dfs(grid, vis, newRow, newCol);
            }   
        }
    }
    public int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        boolean[][] vis = new boolean[m][n];

        for(int i = 0; i < n; i++){
            if(grid[0][i] == 1 && !vis[0][i])
                dfs(grid, vis, 0, i);
            if(grid[m-1][i] == 1 && !vis[m-1][i])
                dfs(grid, vis, m-1, i);
        }

        for(int i = 0; i < m; i++){
            if(grid[i][0] == 1 && !vis[i][0])
                dfs(grid, vis, i, 0);
            if(grid[i][n-1] == 1 && !vis[i][n-1])
                dfs(grid, vis, i, n-1);
        }

        int visCount =0, ones = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(vis[i][j])
                    visCount++;
                if(grid[i][j] == 1)
                    ones++;
            }
        }

        return ones-visCount;


        
    }
}