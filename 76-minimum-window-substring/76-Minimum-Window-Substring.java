class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        int l = 0;
        int count = Integer.MAX_VALUE;
        int unq = map.size();
        int start = 0;
        for(int u = 0; u < s.length(); u++){
            if(map.containsKey(s.charAt(u))){
                map.put(s.charAt(u), map.get(s.charAt(u)) - 1);
                if(map.get(s.charAt(u))==0){
                    unq--;
                }
            }
            while(unq == 0){
                if(u-l+1 < count){
                    count = u-l+1;
                    start = l;
                }
                if(map.containsKey(s.charAt(l))){
                    map.put(s.charAt(l), map.get(s.charAt(l))+1);
                    if(map.get(s.charAt(l)) > 0){
                        unq++;
                    }
                }
                l++;
            }
        }
        return count == Integer.MAX_VALUE ? "" : s.substring(start, start + count);
    }
}