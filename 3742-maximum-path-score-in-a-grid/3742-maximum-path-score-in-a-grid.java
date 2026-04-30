class Solution {
    public int maxPathScore(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][] dp = new int[n][m][k + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(dp[i][j], Integer.MIN_VALUE);
            }
        }

        dp[0][0][0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int t = 0; t <= k; t++) {
                    // Skip already computed states
                    if (dp[i][j][t] != Integer.MIN_VALUE)
                        continue;

                    int currentVal = grid[i][j];
                    int delta = (currentVal > 0) ? 1 : 0;
                    int requiredPrevT = t - delta;
                    if (requiredPrevT < 0)
                        continue;

                    int maxPrev = Integer.MIN_VALUE;

                    // Check top cell (i-1, j)
                    if (i > 0 && dp[i - 1][j][requiredPrevT] > maxPrev) {
                        maxPrev = dp[i - 1][j][requiredPrevT];
                    }

                    // Check left cell (i, j-1)
                    if (j > 0 && dp[i][j - 1][requiredPrevT] > maxPrev) {
                        maxPrev = dp[i][j - 1][requiredPrevT];
                    }

                    if (maxPrev != Integer.MIN_VALUE) {
                        dp[i][j][t] = maxPrev + currentVal;
                    }
                }
            }
        }

        // Find maximum score at destination
        int maxScore = Integer.MIN_VALUE;
        for (int t = 0; t <= k; t++) {
            if (dp[n - 1][m - 1][t] > maxScore) {
                maxScore = dp[n - 1][m - 1][t];
            }
        }

        return (maxScore == Integer.MIN_VALUE) ? -1 : maxScore;
    }
}