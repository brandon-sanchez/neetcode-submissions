class Solution {
    public int characterReplacement(String s, int k) {
        // Map to count frequency of characters in the current window
        HashMap<Character, Integer> hashMap = new HashMap<>();

        int maxFrequency = 0; // Tracks the count of the most frequent character in the window
        int result = 0;       // Stores the maximum valid window length found so far

        int left = 0;         // Left side of the sliding window

        // Expand the right side of the window
        for(int right = 0; right < s.length(); right++) {
            // Add current character to the hash map and update its count
            char currentChar = s.charAt(right);
            hashMap.put(currentChar, hashMap.getOrDefault(currentChar, 0) + 1);

            // Update maxFrequency if the current character appears more than the previous max
            maxFrequency = Math.max(maxFrequency, hashMap.get(currentChar));

            // If the number of characters to change is greater than k, shrink the window
            // (Window size - count of most frequent character) gives us the number of changes needed
            while(((right - left + 1) - maxFrequency) > k) {
                // Shrink the window from the left and update the count of the left character
                char leftChar = s.charAt(left);
                hashMap.put(leftChar, hashMap.get(leftChar) - 1);
                left++; // Move left pointer forward
            }

            // Update the result with the current valid window size
            result = Math.max(result, (right - left + 1));
        }

        return result; // Return the length of the longest valid window
    }
}
