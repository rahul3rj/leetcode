class Solution {
    public int numberOfSubstrings(String s) {
        int a = 0, b = 0, c = 0;
        int l = 0;
        int u = 0;
        int count = 0;
        while (u < s.length() && l < s.length()) {
            if (s.charAt(u) == 'a') {
                a++;
            } else if (s.charAt(u) == 'b') {
                b++;
            } else {
                c++;
            }
            while (a > 0 && b > 0 && c > 0) {
                count += s.length() - u;
                if (s.charAt(l) == 'a') a--;
                else if (s.charAt(l) == 'b') b--;
                else c--;
                l++;
            }
            u++;
        }
        return count;
    }
}