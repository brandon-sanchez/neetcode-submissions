class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //Key: count Value: List
        HashMap<String, List<String>> map = new HashMap<>();

        for(String s : strs) {
            int[] count = new int[26];

            for(char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            String key = Arrays.toString(count);

            if(map.containsKey(key)) {
                ArrayList<String> list = map.get(key);
                map.put(key, list.add(s));
            } else {
                map.put(key, new ArrayList<>());
            }
        }

        return new ArrayList<>(map.values());
    }
}
