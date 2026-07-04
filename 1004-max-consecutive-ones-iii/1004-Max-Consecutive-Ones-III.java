class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0;
        int u = 0;
        int i = k;
        int total = 0;
        while(u < nums.length){
            if(nums[u] == 1){
                u++;
            }else if(nums[u] == 0 && i > 0){
                i--;
                u++;
            }else{
                if(nums[l] == 0){
                    i++;
                }
                l++;
            }
            total = Math.max(total, u-l);
        }
        return total;
    }
}