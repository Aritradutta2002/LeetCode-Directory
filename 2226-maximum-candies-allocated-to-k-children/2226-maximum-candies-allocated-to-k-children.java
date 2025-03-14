class Solution {
   private boolean canAssign(long mid, int[] candies, long k) {
        long count = 0;
        for (int ele : candies) {
            if (ele >= mid)
                count += ele / mid;
        }
        return count >= k;
    }

    public int maximumCandies(int[] candies, long k) {
        long low = 1;
        long high = Arrays.stream(candies).max().getAsInt();
        long mid;
        long max_candies = 0;

        
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (canAssign(mid, candies, k)) {
                max_candies = Math.max(max_candies, mid);
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return (int) max_candies;
    }
}