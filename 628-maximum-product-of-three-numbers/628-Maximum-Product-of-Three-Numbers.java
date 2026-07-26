class Solution {
    public int maximumProduct(int[] nums) {
        if(nums.length < 3){
            return 0;
        }
        Arrays.sort(nums);
        int op1 = nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
        int op2 = nums[0] * nums[1] * nums[nums.length - 1];
        return Math.max(op1, op2);
    }
}