class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> mySet = new HashSet<>();

        for(int num : nums) {
            if(!mySet.contains(num)) {
                mySet.add(num);
            } else {
                return true;
            }
        }

        return false;
    }
}