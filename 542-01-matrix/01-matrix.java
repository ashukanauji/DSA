class Pair{
    int row;
    int col;
    int dist;
    Pair(int row, int col, int dist){
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;

        int[][] vis = new int[m][n];

        int[][] ans = new int[m][n];

        Queue<Pair> queue = new LinkedList<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0){
                    queue.add(new Pair(i,j,0));
                    vis[i][j] = 1;
                }       
            }
        }

        int dRow[] = {-1, 0,+1, 0};
            int dCol[] = {0, +1, 0, -1};

        while(!queue.isEmpty()){
            int row = queue.peek().row;
            int col = queue.peek().col;
            int dist = queue.peek().dist;

            ans[row][col] = dist;
            vis[row][col] = 1;

            for(int i = 0; i < 4; i++){ 
                int newRow = row + dRow[i];
                int newCol = col + dCol[i];

                if(newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && vis[newRow][newCol] == 0){
                queue.add(new Pair(newRow, newCol, dist+1));
                vis[newRow][newCol] = 1;
                }
            }
            queue.remove();
        }
        return ans;
    }
}