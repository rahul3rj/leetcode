class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int freshCount = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j]==1){
                    freshCount++;
                }else if(grid[i][j] == 2){
                    q.offer(new int[]{i,j});
                }
            }
        }
        if(freshCount == 0){
            return 0;
        }
        int time = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int rotLoc[] = q.poll();
                int r = rotLoc[0];
                int c = rotLoc[1];
                int padosis[][] = {{r-1,c}, {r,c+1}, {r+1,c}, {r,c-1}};
                for(int padosi[] : padosis){
                    int nr = padosi[0];
                    int nc = padosi[1];
                    if(nr < 0 || nr >= n || nc < 0 || nc >= m || grid[nr][nc] != 1){
                        continue;
                    }
                    q.offer(new int[]{nr,nc});
                    grid[nr][nc] = 2;
                    freshCount--;
                    if(freshCount==0){
                        return time + 1;
                    }
                }
            }
            time++;
        }
        return -1;
    }
}