class Solution {
    public long countCommas(long n) {
        if(n < 1000){
            return 0;
        }
        long res = 0;
        
        if((long) Math.pow(10, 3) <= n){
            res += ((n - (long) Math.pow(10, 3)) + 1);
        }
        if((long) Math.pow(10, 6) <= n){
            res += ((n - (long) Math.pow(10, 6)) + 1);
        }
        if((long) Math.pow(10, 9) <= n){
            res += ((n - (long) Math.pow(10, 9)) + 1);
        }
        if((long) Math.pow(10, 12) <= n){
            res += ((n - (long) Math.pow(10, 12)) + 1);
        }
        if((long) Math.pow(10, 15) <= n){
            res += ((n - (long) Math.pow(10, 15)) + 1);
        }
        return res;
    }
}