class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        //Mapping charCount to List of Anagrams (Key: character count | Value: List of anagrams (words) matching that count)
        HashMap<String, List<String>> resHashMap = new HashMap<>();

        for (String word : strs) {
            int[] count = new int[26]; //a...z
            for (char c : word.toCharArray()) {
                count[c - 'a']++;
            }

            String key = Arrays.toString(count);
            resHashMap.putIfAbsent(key, new ArrayList<>());
            resHashMap.get(key).add(word);
        }
        return new ArrayList<>(resHashMap.values());
        
    }
}
