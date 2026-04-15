class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // Step 1: Sort the input array to make it easier to skip duplicates and use two pointers
        Arrays.sort(nums);

        // Step 2: Prepare a list to store the resulting triplets
        List<List<Integer>> result = new ArrayList<>();

        // Step 3: Iterate through the array with a fixed pointer 'i'
        for(int i = 0; i < nums.length; i++) {

            // Optimization: if the current number is greater than 0, we can break early
            // Because the array is sorted, any triplet including this number will sum > 0
            if(nums[i] > 0) {
                break;
            }

            // Skip duplicates: if the current number is the same as the previous, skip it
            // to avoid duplicate triplets in the result
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Step 4: Use two pointers to find two numbers that sum to -nums[i]
            int left = i + 1;
            int right = nums.length - 1;

            // Continue moving the pointers as long as left is to the left of right
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if(sum > 0) {
                    // If the sum is too big, move the right pointer left to try a smaller number
                    right--;
                } else if (sum < 0) {
                    // If the sum is too small, move the left pointer right to try a larger number
                    left++;
                } else {
                    // Found a valid triplet that sums to 0
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Move both pointers to look for new pairs
                    left++;
                    right--;

                    // Skip duplicates on the left pointer
                    while(left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                }
            }
        }

        // Return all found triplets
        return result;
    }
}
