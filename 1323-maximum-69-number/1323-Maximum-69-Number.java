class Solution {
    public int maximum69Number (int num) {
        int len = String.valueOf(num).length();
        int temp[] = new int[len];
        for(int i = len - 1; i >= 0; i--){
            temp[i] = num % 10;
            num /= 10;
        }
        for(int i = 0; i < temp.length; i++){
            if(temp[i] == 6){
                temp[i] = 9;
                break;
            }
        }
        int ans = 0;
        for(int i = 0; i < temp.length; i++){
            ans = ans * 10 + temp[i];
        }
        return ans;
    }
}