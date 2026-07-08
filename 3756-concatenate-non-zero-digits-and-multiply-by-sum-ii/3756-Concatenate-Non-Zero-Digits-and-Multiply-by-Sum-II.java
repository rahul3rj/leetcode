class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();
        int MOD = 1_000_000_007;
        long[] prefSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefSum[i + 1] = prefSum[i] + (s.charAt(i) - '0');
        }
        long[] prefRes = new long[n + 1];
        int[] nonZeroCount = new int[n + 1]; 
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch != '0') {
                prefRes[i + 1] = (prefRes[i] * 10 + (ch - '0')) % MOD;
                nonZeroCount[i + 1] = nonZeroCount[i] + 1;
            } else {
                prefRes[i + 1] = prefRes[i];
                nonZeroCount[i + 1] = nonZeroCount[i];
            }
        }
        long[] power10 = new long[n + 1];
        power10[0] = 1;
        for (int i = 1; i <= n; i++) {
            power10[i] = (power10[i - 1] * 10) % MOD;
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int u = queries[i][1];
            long sum = (prefSum[u + 1] - prefSum[l]) % MOD;
            if (sum == 0) {
                ans[i] = 0;
                continue;
            }
            int nonZerosInWindow = nonZeroCount[u + 1] - nonZeroCount[l];
            long res = (prefRes[u + 1] - (prefRes[l] * power10[nonZerosInWindow]) % MOD + MOD) % MOD;
            
            ans[i] = (int) ((res * sum) % MOD);
        }
        
        return ans;
    }
}