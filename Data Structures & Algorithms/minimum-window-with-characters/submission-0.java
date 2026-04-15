public class Solution {
    public String minWindow(String s, String t) {
        // Edge case: if t is empty, return empty string
        if (t.isEmpty()) return "";

        // Maps to store character frequencies
        Map<Character, Integer> targetFreq = new HashMap<>(); // character counts in t
        Map<Character, Integer> windowFreq = new HashMap<>(); // character counts in current window of s

        // Build the target frequency map using t
        for (char c : t.toCharArray()) {
            targetFreq.put(c, targetFreq.getOrDefault(c, 0) + 1);
        }

        // 'have' counts how many unique required characters in current window match required freq
        // 'need' is how many unique characters we need to match (keys in targetFreq)
        int have = 0, need = targetFreq.size();

        // To store the result window (start and end indices)
        int[] resultWindow = {-1, -1};
        int minWindowLength = Integer.MAX_VALUE;

        int left = 0; // Left pointer of sliding window

        // Expand the window using the right pointer
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            windowFreq.put(currentChar, windowFreq.getOrDefault(currentChar, 0) + 1);

            // If the current character is needed and its frequency matches the target, increase 'have'
            if (targetFreq.containsKey(currentChar) && 
                windowFreq.get(currentChar).equals(targetFreq.get(currentChar))) {
                have++;
            }

            // Try to shrink the window from the left while it still satisfies the requirement
            while (have == need) {
                // Update result if this window is smaller than previous best
                if ((right - left + 1) < minWindowLength) {
                    minWindowLength = right - left + 1;
                    resultWindow[0] = left;
                    resultWindow[1] = right;
                }

                // Remove the leftmost character from the window
                char leftChar = s.charAt(left);
                windowFreq.put(leftChar, windowFreq.get(leftChar) - 1);

                // If a required character's frequency drops below target, reduce 'have'
                if (targetFreq.containsKey(leftChar) && 
                    windowFreq.get(leftChar) < targetFreq.get(leftChar)) {
                    have--;
                }

                // Move left pointer to shrink window
                left++;
            }
        }

        // If no valid window found, return empty string
        return minWindowLength == Integer.MAX_VALUE ? "" : s.substring(resultWindow[0], resultWindow[1] + 1);
    }
}
