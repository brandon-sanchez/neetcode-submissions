class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int num : nums) {
            set.add(num);
        }

        int longest = 0;
        for(int num : nums) {
            int currLong = 1;
            if(!set.contains(num - 1)) {
                while(set.contains(num + 1)) {
                    currLong++;
                    num++;
                }

                longest = Math.max(longest, currLong);
            }
        }

        return longest;
    }
}
