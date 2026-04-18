class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> mySet = new HashSet<>();

        for(int num : num) {
            if(!mySet.contains(num)) {
                mySet.add(num);
            } else {
                return false;
            }
        }

        return true;
    }
}