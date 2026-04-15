class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> hashMap = new HashMap<>();

        int maxFrequency = 0;
        int result = 0;

        int left = 0;

        for(int right = 0; right < s.length(); right++) {
            hashMap.put(s.charAt(right), hashMap.getOrDefault(s.charAt(right), 0) + 1);
            maxFrequency = Math.max(maxFrequency, hashMap.get(s.charAt(right)));

            while(((right - left + 1) - maxFrequency) > k) {
                hashMap.put(s.charAt(left), hashMap.get(s.charAt(left)) - 1);
                left++;
            }

            result = Math.max(result, (right - left + 1));
        }

        return result;
    }
}
