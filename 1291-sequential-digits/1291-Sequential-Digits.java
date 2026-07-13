class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> list = new ArrayList<>();
        int all[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int start = String.valueOf(low).length();
        int end = String.valueOf(high).length();
        for (int i = start; i <= end; i++) {
            int l = 0;
            int u = 0;
            while (u < all.length) {
                if (u - l + 1 == i) {
                    int count = 0;
                    for (int j = l; j <= u; j++) {
                        count = (count * 10) + all[j];
                    }
                    if (count <= high && count >= low) {
                        list.add(count);
                    }
                    l++;
                }
                u++;
            }
        }
        return list;
    }
}