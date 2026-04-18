class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        //Key: string (sorted) Value: List of strings
        HashMap<String, List<String>> map = new HashMap<>(); 
        
        List<List<String>> result = new ArrayList<>();

        for(String str : strs) {
            cha[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedString = new String(charArray);

            if(map.get(sortedString) != null) {
                List<String> list = map.get(sortedString);
                map.put(sortedString, list.add(str));
            } else {
                List<String> newList = new ArrayList<>();
                map.put(sortedString, newList.add(str));
            }
        }

        for(List<String> list : map.values()) {
            result.add(list);
        }

        return result;
    }
}
