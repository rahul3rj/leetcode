class Solution {
    public String interpret(String command) {
        String res = new String();
        for(int i = 0; i < command.length(); i++){
            if(command.charAt(i) == '('){
                if(command.charAt(i+1) == ')'){
                    res += 'o';
                    continue;
                }else{
                    continue;
                }
            }else if(command.charAt(i) == ')'){
                continue;
            }
            res += command.charAt(i);
        }
        return res;
    }
}