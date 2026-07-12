class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] nums = arr.clone();
        Arrays.sort(nums);

        Map<Integer, Integer> map = new HashMap<>();
        int count= 1;
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], count);
                count++;
            }
        }

        int res[] = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            res[i] = map.get(arr[i]);
        }
        return res;
    }
}