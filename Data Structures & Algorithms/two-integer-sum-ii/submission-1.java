class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int val1 = numbers[left];
            int val2 = numbers[right];

            if(val1 + val2 == target) {
                return new int[] {left + 1, right + 1};
            }

            if(val1 + val2 > target) {
                right--;
            } else {
                left++;
            }
        }

        return new int[] {};
    }
}
