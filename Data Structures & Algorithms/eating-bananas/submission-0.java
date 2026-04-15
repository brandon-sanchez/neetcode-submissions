class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();

        int result = right;

        while (left <= right) {
            int totalHours = 0;

            int k = left + (right - left) / 2;

            for(int pile : piles) {
                totalHours += Math.ceil((double) pile / k);
            }

            if(totalHours > h) {
                left = k + 1;
            } else {
                result = k;
                right = k - 1;
            }
        }

        return result;
       
    }
}
