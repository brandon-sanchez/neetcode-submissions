class Solution {
    public int[] twoSum(int[] nums, int target) {

        //Key: Value | Value: Element Number
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        
        
       for(int i = 0; i < nums.length; i++) {
        int value = nums[i];
        int diff = target - value;

        //If already in hashMap
        if(hashMap.containsKey(diff)) {
            return new int[] {hashMap.get(diff), i};
        }

        //If not in hashMap, then put into hashMap
        hashMap.put(value, i);
       }
       return new int[] {};
    }
}
