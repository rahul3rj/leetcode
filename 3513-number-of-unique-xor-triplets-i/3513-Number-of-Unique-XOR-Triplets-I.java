class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int bits = 0;
        if(nums.length < 3){
            return nums.length;
        }
        while((1 << bits) <= nums.length){
            bits++;
        }
        return (1 << bits);
    }
}