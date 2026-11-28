class Solution {
    public String mergeAlternately(String word1, String word2) {
        int n = Math.max(word1.length(), word2.length());
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < n; i++){
            if(i < word1.length()){
                ans.append(word1.charAt(i));
            }
            if(i < word2.length()){
                ans.append(word2.charAt(i));
            }
        }
        return ans.toString();
    }
}