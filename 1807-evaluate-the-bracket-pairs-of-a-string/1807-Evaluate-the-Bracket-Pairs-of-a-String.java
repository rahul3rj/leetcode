class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for(int i = 0; i < knowledge.size(); i++){
            map.put(knowledge.get(i).get(0), knowledge.get(i).get(1));
        }
        StringBuilder result = new StringBuilder();
        int pt = 0;
        int n = s.length();
        while(pt < n){
            if(s.charAt(pt) == '('){
                int start = pt + 1;
                int end = s.indexOf(')', start);
                String key = s.substring(start, end);
                result.append(map.getOrDefault(key, "?"));
                pt = end + 1;
            }else{
                result.append(s.charAt(pt));
                pt++;
            }
        }
        return result.toString();
    }
}