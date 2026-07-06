class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[0] == b[0])? Integer.compare(b[1], a[1]): Integer.compare(a[0], b[0]));
        int u = 0;
        int count = intervals.length;
        for (int i = 0; i < intervals.length; i++){
            if(intervals[i][1] <= u){
                count--;
            }else{
                u = intervals[i][1];
            }
        }
        return count;
    }
}