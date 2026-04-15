class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        //Key: string (sorted) Value: List of strings
        HashMap<String, List<String>> map = new HashMap<>(); 
        
        List<List<String>> result = new ArrayList<>();

        for(String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedString = new String(charArray);


            map.computeIfAbsent(sortedString, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
