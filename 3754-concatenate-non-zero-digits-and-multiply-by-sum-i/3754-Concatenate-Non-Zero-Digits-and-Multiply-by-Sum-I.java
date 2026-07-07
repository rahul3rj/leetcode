class Solution {
    public long sumAndMultiply(int n) {
        String temp = Integer.toString(n).replace("0", "");
        long sum = 0;
        if(temp == ""){
            return 0;
        }
        long res = Integer.parseInt(temp);
        for(int i = 0; i < temp.length(); i++){
            sum += temp.charAt(i) - '0';
        }
        return res * sum;
    }
}