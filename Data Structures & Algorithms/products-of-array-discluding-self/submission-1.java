class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;

        // This array will hold our final result
        int[] result = new int[length];

        // --- First Pass: Prefix Product ---
        // Initialize the first element of result as 1
        // Because there's nothing to the left of the first element
        result[0] = 1;

        // Build up the prefix product for each element
        // result[i] = product of all elements to the left of index i
        for(int i = 1; i < length; i++) {
            // result[i - 1] holds product of all elements to the left of i - 1
            // nums[i - 1] is the element just before i
            // So multiplying gives us the product up to i - 1
            result[i] = result[i - 1] * nums[i - 1];
        }

        /*
         Example:
         nums = [1, 2, 3, 4]
         After prefix pass:
         result = [1, 1, 2, 6]
         Explanation:
         result[1] = 1 * nums[0] = 1
         result[2] = 1 * nums[1] = 2
         result[3] = 2 * nums[2] = 6
        */

        // --- Second Pass: Postfix Product ---
        // Start from the end and work backwards
        // Initialize postfix as 1 (since nothing is to the right of the last element)
        int postfix = 1;

        for(int i = length - 1; i >= 0; i--) {
            // Multiply current prefix product with the postfix product
            result[i] *= postfix;

            // Update postfix to include current number
            postfix *= nums[i];
        }

        /*
         Continuing the example:
         postfix starts at 1

         i = 3 → result[3] = 6 * 1 = 6, postfix = 1 * 4 = 4
         i = 2 → result[2] = 2 * 4 = 8, postfix = 4 * 3 = 12
         i = 1 → result[1] = 1 * 12 = 12, postfix = 12 * 2 = 24
         i = 0 → result[0] = 1 * 24 = 24

         Final result = [24, 12, 8, 6]
         Each element is the product of all other elements except itself
        */

        return result;
    }
}
