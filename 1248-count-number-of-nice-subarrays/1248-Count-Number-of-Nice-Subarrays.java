class Solution {
    public int numofsubarraykth(int[] nums, int k) {
        int l = 0;
        int count = 0;
        int frq = 0;
        for(int u = 0; u < nums.length; u++){
            if(nums[u] % 2 != 0){
                frq++;
            }
            while(l <= u && frq > k){
                if(nums[l] % 2 != 0) {
                    frq--;
                }
                l++;
            }
            count += (u - l + 1);
        }
        return count;
    }

    public int numberOfSubarrays(int[] nums, int k) {
        return numofsubarraykth(nums, k) - numofsubarraykth(nums, k-1);
    }
}