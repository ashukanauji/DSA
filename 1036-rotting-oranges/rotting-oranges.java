class Pair{
    int row;
    int col;
    int time;
    Pair(int row, int col, int time){
        this.row = row;
        this.col = col;
        this.time = time;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        int[][] vis = new int[m][n];

        int isFresh = 0;

        for(int i =0; i < m; i++){
            for(int j = 0; j < n ; j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i,j,0));
                    vis[i][j] = 2;
                }    
                else vis[i][j] =0;

                if(grid[i][j] == 1)
                    isFresh++;
            }
        }

        int time = 0;
        int dRow[] = {-1, 0,+1, 0};
        int dCol[] = {0, +1, 0, -1};
        int count = 0;


        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().time;
            
            time = Math.max(t, time);

            for(int i =0; i < 4; i++){
                int nRow = r + dRow[i];
                int nCol = c + dCol[i];
                if(nRow >=0 && nCol >= 0 && nRow < m && nCol < n && vis[nRow][nCol] != 2 && grid[nRow][nCol] == 1){
                    q.add(new Pair(nRow, nCol, time+1));
                    vis[nRow][nCol] = 2;
                    count++;
                }
            }
            q.remove();
        }

        if(count != isFresh)
            return -1;
        return time;
    }
}