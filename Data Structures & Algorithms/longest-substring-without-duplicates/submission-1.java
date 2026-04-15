class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int currentMaxSubstring = 0;
        
        int left = 0;
        for(int right = 0; right < s.length(); right++) {
            while(set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            currentMaxSubstring = Math.max(currentMaxSubstring, (right - left + 1));
        }

        return currentMaxSubstring;
    }
}
