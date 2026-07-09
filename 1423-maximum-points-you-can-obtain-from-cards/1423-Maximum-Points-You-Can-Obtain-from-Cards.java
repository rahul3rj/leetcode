class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int l = 0;
        int count = 0;
        int frq = 0;
        int sum = 0;
        for(int i = 0; i < cardPoints.length; i++){
            sum += cardPoints[i];
        }
        if (k == cardPoints.length) return sum;
        for(int u = 0; u < cardPoints.length; u++){
            frq += cardPoints[u];
            if(u - l + 1 == (cardPoints.length - k)){
                count = Math.max(count, sum - frq);
                frq -= cardPoints[l];
                l++;
            }
        }
        return count;
    }
}