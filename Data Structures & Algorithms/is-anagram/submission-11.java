class Solution {
    public boolean isAnagram(String s, String t) {
        int[] sCount = new int[26];
        int[] tCount = new int[26];

        if(s.length() != t.length()) {
            return false;
        }

        for(int i = 0; i < s.length(); i++) {
            sCount['a' - s.charAt(i)]++;
            tCount['a' - t.charAt(i)]++;
        }

        return Arrays.equals(sCount, tCount);
    }
}
