class Solution {
    public String smallestSubsequence(String s) {
        Stack<Character> lex = new Stack<>();
        int last[] = new int[26];
        for(int i = 0; i < s.length(); i++){
            last[s.charAt(i) - 'a'] = i;
        }
        boolean rep[] = new boolean[26];
        for(int i = 0; i < s.length(); i++){
            if(rep[s.charAt(i) - 'a']) continue;
            while(lex.size() > 0 && lex.peek() > s.charAt(i) && i < last[lex.peek() - 'a']){
                rep[lex.peek() - 'a'] = false;
                lex.pop();
            }
            lex.push(s.charAt(i));
            rep[s.charAt(i) - 'a'] = true;
        }
        String res = new String();
        while(lex.size() > 0){
            res += lex.peek();
            lex.pop();
        }
        String reversed = new StringBuilder(res).reverse().toString();
        return reversed;
    }
}