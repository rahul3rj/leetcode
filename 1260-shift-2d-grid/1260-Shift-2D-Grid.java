class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length;
        int nGrid[] = new int[m*n];
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < nGrid.length; i++){
            nGrid[i] = grid[i / m][i % m];
        }
        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                row.add(0);
            }
            res.add(row);
        }
        for(int i = 0; i < nGrid.length; i++){
            int newIdx = (i + k) % nGrid.length;
            res.get(newIdx / m).set(newIdx % m, nGrid[i]);
        }
        return res;
    }
}