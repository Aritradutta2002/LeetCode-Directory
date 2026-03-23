class Solution {
    public int maxProductPath(int[][] grid) {
        long MOD = 1000000007;
        int m = grid.length;
        int n = grid[0].length;

        // dp[i][j][0] = maximum product at (i, j)
        // dp[i][j][1] = minimum product at (i, j)
        long[][][] dp = new long[m][n][2];

        // Initialize starting position
        dp[0][0][0] = grid[0][0];
        dp[0][0][1] = grid[0][0];

        // Fill first row (can only come from left)
        for (int j = 1; j < n; j++) {
            dp[0][j][0] = dp[0][j - 1][0] * grid[0][j];
            dp[0][j][1] = dp[0][j - 1][1] * grid[0][j];
        }

        // Fill first column (can only come from top)
        for (int i = 1; i < m; i++) {
            dp[i][0][0] = dp[i - 1][0][0] * grid[i][0];
            dp[i][0][1] = dp[i - 1][0][1] * grid[i][0];
        }

        // Fill the rest of the table
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // Get max and min from top and left
                long maxFromTop = dp[i - 1][j][0];
                long minFromTop = dp[i - 1][j][1];
                long maxFromLeft = dp[i][j - 1][0];
                long minFromLeft = dp[i][j - 1][1];

                // Current cell value
                long current = grid[i][j];

                // Calculate all possibilities
                long[] candidates = {
                        maxFromTop * current,
                        minFromTop * current,
                        maxFromLeft * current,
                        minFromLeft * current
                };

                // Find max and min
                long maxVal = Long.MIN_VALUE;
                long minVal = Long.MAX_VALUE;
                for (long c : candidates) {
                    maxVal = Math.max(maxVal, c);
                    minVal = Math.min(minVal, c);
                }

                dp[i][j][0] = maxVal;
                dp[i][j][1] = minVal;
            }
        }

        long result = dp[m - 1][n - 1][0];

        // If maximum product is negative, return -1
        if (result < 0) {
            return -1;
        }

        return (int) (result % MOD);
    }
}