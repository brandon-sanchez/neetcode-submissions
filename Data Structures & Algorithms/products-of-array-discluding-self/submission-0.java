class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;

        int[] result = new int[length];

        //Prefix
        result[0] = 1;
        for(int i = 1; i < length; i++) {
            //Prefix = previous result value * value in nums
            result[i] = result[i - 1] * nums[i - 1];
        }

        //Postfix
        int postfix = 1;
        for(int i = length - 1; i >= 0; i--) {
            //New value = prefix (current value in array) * postfix
            result[i] *= postfix;
            //Update postfix value
            postfix *= nums[i];
        }

        return result;
    }
}  
