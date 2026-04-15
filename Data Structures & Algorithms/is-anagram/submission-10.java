class Solution {
    public boolean isAnagram(String s, String t) {
        char[] count = new char[26];

        if(s.length() != t.length()) {
            return false;
        }

        for(int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for(char c : count) {
            if(c != 0) {
                return false;
            }
        }

        return true;
    }
}
