class Solution {
    public int subkth(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int l = 0;
        int u = 0;
        int count = 0;
        while (u < nums.length) {
            map.put(nums[u], map.getOrDefault(nums[u], 0) + 1);
            while (map.size() > k) {
                map.put(nums[l], map.get(nums[l]) - 1);
                if (map.get(nums[l]) == 0) {
                    map.remove(nums[l]);
                }
                l++;
            }
            count += u - l + 1;
            u++;

        }
        return count;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        return subkth(nums, k) - subkth(nums, k - 1);
    }
}