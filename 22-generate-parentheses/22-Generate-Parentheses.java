class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate("" , n, 0, 0, ans);
        return ans;
    }
    public void generate(String curr, int n, int open, int close, List<String> ans){
        if(curr.length() == 2*n){
            ans.add(curr);
            return;
        }
        if(open < n){
            generate(curr + "(", n, open + 1, close, ans);
        }
        if(close < open){
            generate(curr + ")", n, open, close + 1, ans);
        }
    }
}