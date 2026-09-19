class Solution {
    private void dfs(int row, int col, int vis[][], char board[][], int delrow[], int delcol[]){
        vis[row][col] = 1;
        int n = board.length;
        int m = board[0].length;
        for(int i = 0; i < 4; i++){
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && board[nrow][ncol] == 'O'){
                dfs(nrow, ncol, vis, board, delrow, delcol);
            }
        }
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int delrow[] = {-1, 0, +1, 0};
        int delcol[] = {0, +1, 0, -1};
        int vis[][] = new int[n][m];
        for(int i = 0; i < m; i++){
            if(vis[0][i] == 0 && board[0][i] == 'O'){
                dfs(0, i, vis, board, delrow, delcol);
            }
            if(vis[n-1][i] == 0 && board[n-1][i] == 'O'){
                dfs(n-1, i, vis, board, delrow, delcol);
            }
        }
        for(int i = 0; i < n; i++){
            if(vis[i][0] == 0 && board[i][0] == 'O'){
                dfs(i, 0, vis, board, delrow, delcol);
            }
            if(vis[i][m-1] == 0 && board[i][m-1] == 'O'){
                dfs(i, m-1, vis, board, delrow, delcol);
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(vis[i][j] == 0 && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }
}