class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> countS = new HashMap<Character,Integer>();
        HashMap<Character,Integer> countT = new HashMap<Character,Integer>();

        //default case
        if (s.length() != t.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            // for s string
            countS.put(s.charAt(i), countS.getOrDefault(s.charAt(i), 0) + 1)

            //for t string
            countT.put(s.charAt(i), countS.getOrDefault(s.charAt(i), 0) + 1)
        }
        return countS.equals(countT);
    }
}
