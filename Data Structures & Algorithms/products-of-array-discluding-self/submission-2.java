class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefixSum = new int[nums.length + 1];

        prefixSum[0] = 1;

        for(int i = 1; i < nums.length; i++) {
            prefixSum[i] += prefixSum[i - 1];
        }
    }
}  
