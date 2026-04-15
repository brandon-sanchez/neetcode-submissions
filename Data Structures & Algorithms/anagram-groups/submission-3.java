class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // HashMap to group anagrams. Key is a character count signature, value is list of words with that signature
        HashMap<String, List<String>> hashMap = new HashMap<>();

        // Loop through each word in the input array
        for(String s : strs) {
            int[] charCountArray = new int[26]; // Count of each character a-z for the current word
            
            // Build the count array for the current word
            for(char c : s.toCharArray()) {
                charCountArray[c - 'a']++; // Increment the count for this character
            }

            // Convert the count array into a string key (e.g., "[1, 0, 0, ..., 1]" for "ab")
            String key = Arrays.toString(charCountArray);

            // If this key is not in the map, create a new list
            hashMap.putIfAbsent(key, new ArrayList<>());

            // Add the current word to the list of its anagram group
            hashMap.get(key).add(s);
        }

        // Return all grouped anagrams as a list of lists
        return new ArrayList<>(hashMap.values());
    }
}
