class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hashMap = new HashMap<>();

        for(String s : strs) {
            int[] charCountArray = new int[26];

            for(char c : s.toCharArray()) {
                charCountArray[c - 'a']++;
            }

            String key = Arrays.toString(charCountArray);
            hashMap.putIfAbsent(key, new ArrayList<>());
            hashMap.get(key).add(s);
        }

        return new ArrayList<>(hashMap.values());
    }
}
