class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> hs = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            hs.add(nums[i]);
        }
        int arr[] = new int[nums.length + 1];
        for(int i = 0; i < nums.length +1; i++){
            arr[i] = k*(i+1);
        }
        for(int i = 0; i < arr.length; i++){
            if(!hs.contains(arr[i])){
                return arr[i];
            }
        }
        return -1;
    }
}