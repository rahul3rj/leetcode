class Solution {
    public int characterReplacement(String s, int k) {
        int frq[] = new int[26];
        int l = 0, u = 0;
        int i = k;
        int max = 0;
        int maxfrq = 0;
        while(u < s.length()){
            frq[s.charAt(u) - 'A']++;
            maxfrq = Math.max(maxfrq, frq[s.charAt(u) - 'A']);
            if((u-l+1) - maxfrq > k){
                frq[s.charAt(l) - 'A']--;
                l++;
            }
            max = Math.max(max, u-l+1);
            u++;
        }
        return max;
    }
}