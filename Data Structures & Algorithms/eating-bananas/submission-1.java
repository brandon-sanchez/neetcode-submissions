class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        // Minimum possible eating speed is 1 banana/hour
        int left = 1;

        // Maximum possible eating speed is the largest pile
        // (because eating faster than that won't save time)
        int right = Arrays.stream(piles).max().getAsInt();

        // Initialize result with the maximum possible speed
        int result = right;

        // Binary search to find the smallest valid eating speed
        while (left <= right) {
            // Midpoint: test this speed
            int k = left + (right - left) / 2;

            // Calculate total hours needed to eat all piles at speed k
            int totalHours = 0;
            for (int pile : piles) {
                // Round up because Koko can't eat partial bananas in less than an hour
                totalHours += Math.ceil((double) pile / k);
            }

            // If it takes more than h hours, k is too slow — try faster speeds
            if (totalHours > h) {
                left = k + 1;
            } else {
                // k is fast enough — try to find a smaller valid speed
                result = k;
                right = k - 1;
            }
        }

        // result holds the smallest speed that works within h hours
        return result;
    }
}
