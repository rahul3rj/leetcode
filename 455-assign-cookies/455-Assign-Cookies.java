class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int l = 0;
        int u = 0;
        while(l < g.length && u < s.length){
            if(g[l] <= s[u]){
                count++;
                l++;
            }
            u++;
        }
        return count;
    }
}