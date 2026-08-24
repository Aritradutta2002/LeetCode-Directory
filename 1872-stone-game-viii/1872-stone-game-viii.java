class Solution {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;
        long prefix = 0;
        for (int stone : stones) {
            prefix += stone;
        }

        long best = prefix; // dp[n-2] = prefix[n-1]
        for (int i = n - 3; i >= 0; i--) {
            prefix -= stones[i + 2]; // prefix now holds prefix[i+1]
            best = Math.max(best, prefix - best);
        }
        return (int) best;
    }
}