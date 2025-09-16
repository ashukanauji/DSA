class Solution {
    private static void dfs(char[][]board, boolean[][] vis, int row, int col){
        int m = board.length, n = board[0].length;

        vis[row][col] = true;
         

        int[] dRow = {0, 1, 0, -1};
        int[] dCol = {1, 0, -1, 0};

        for(int i = 0; i < 4; i++){
            int newRow = row + dRow[i];
            int newCol = col + dCol[i];

            if(newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && board[newRow][newCol] == 'O' && vis[newRow][newCol] == false ){
                dfs(board, vis, newRow, newCol);
            }   
        }
    }

    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;

        boolean[][] vis = new boolean[m][n];

        // Check boundary rows
        for(int j = 0; j < n; j++) {
            if(board[0][j] == 'O' && !vis[0][j])
                dfs(board, vis, 0, j);
            if(board[m-1][j] == 'O' && !vis[m-1][j])
                dfs(board, vis, m-1, j);
        }

        // Check boundary columns
        for(int i = 0; i < m; i++) {
            if(board[i][0] == 'O' && !vis[i][0])
                dfs(board, vis, i, 0);
            if(board[i][n-1] == 'O' && !vis[i][n-1])
                dfs(board, vis, i, n-1);
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(vis[i][j] == true)
                    board[i][j] = 'O';
                else
                    board[i][j] = 'X';
            }
        }
        
    }
}