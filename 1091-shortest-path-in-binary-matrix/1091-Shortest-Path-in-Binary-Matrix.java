class Solution {
    static class Pair{
        int row, col, pathValue;
        Pair(int row, int col, int pathValue){
            this.row = row;
            this.col = col;
            this.pathValue = pathValue;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1) return -1;
        int n = grid.length, min = Integer.MAX_VALUE;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, 0, 1));
        int dirRow[] = {0, -1, 1, -1, 1, -1, 1, 0};
        int dirCol[] = {-1, -1, -1, 0, 0, 1, 1, 1};
        while(!q.isEmpty()){
            Pair curr = q.poll();
            if(curr.row == n-1 && curr.col == n-1) return curr.pathValue;
            for(int i = 0; i < 8; i++){
                int newRow = curr.row + dirRow[i];
                int newCol = curr.col + dirCol[i];
                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && grid[newRow][newCol] == 0){
                    grid[newRow][newCol] = 1;
                    q.add(new Pair(newRow, newCol, curr.pathValue + 1));
                }
            }
        }
        return min == Integer.MAX_VALUE?-1:min;
    }
}