class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> countHashMap = new HashSet<>();
        //loop through the array
        for(int num : nums) {
            if (countHashMap.contains(num)){
                return true;
            } else {
                countHashMap.add(num);
            }
        }
        return false;
    }
}
