class Solution {
    private static void dfs(int node, ArrayList<ArrayList<Integer>> adjLs, int vis[]) {
        vis[node] = 1;
        for (int i = 0; i < adjLs.get(node).size(); i++) {
            int neighbor = adjLs.get(node).get(i);

            if (vis[neighbor] == 0) {
                dfs(neighbor, adjLs, vis);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;
        ArrayList<ArrayList<Integer>> adjLs = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adjLs.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < V; i++){
            for(int j = 0; j < V; j++){
                if(isConnected[i][j] == 1 && i != j){
                    adjLs.get(i).add(j);
                    adjLs.get(j).add(i);
                }
            }
        }
        int[] vis = new int[V];
        int count = 0;
        for(int i = 0; i < V; i++){
            if(vis[i] == 0){
                count++;
                dfs(i, adjLs, vis);
            }
        }
        return count;
    }
}