class Solution {
    public int maxDepth(String s) {
        int out = 0;
        int par = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                par++;
            }else if(s.charAt(i) == ')'){
                par--;
            }
            out = Math.max(out, par);
        }
        return out;
    }
}