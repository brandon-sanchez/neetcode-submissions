class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> numIndex = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];

            if(numIndex.containsKey(difference)) {
                return new int[] {i, numIndex.get(difference)};
            }

            numIndex.put(nums[i], i);
        }

        return new int[] {};
    }
}
