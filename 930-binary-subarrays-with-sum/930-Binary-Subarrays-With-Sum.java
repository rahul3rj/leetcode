class Solution {
    public int kthSum(int[] nums, int goal) {
        int l = 0;
        int count = 0;
        int frq = 0;
        for(int u = 0; u < nums.length; u++){
            frq += nums[u];
            while(l <= u && frq > goal){
                frq -= nums[l];
                l++;
            }
            count += (u - l + 1);
        }
        return count;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        return kthSum(nums, goal) - kthSum(nums, goal-1);
    }
}