class Solution {
    public int maxProductPath(int[][] grid) {
        long MOD = 1000000007;
        int m = grid.length;
        int n = grid[0].length;

        // Create two 2D DP arrays - easier to understand than 3D
        long[][] maxDp = new long[m][n]; // Maximum product at each cell
        long[][] minDp = new long[m][n]; // Minimum product at each cell

        // Initialize starting position
        maxDp[0][0] = grid[0][0];
        minDp[0][0] = grid[0][0];

        // Fill first row (can only come from left)
        for (int j = 1; j < n; j++) {
            maxDp[0][j] = maxDp[0][j - 1] * grid[0][j];
            minDp[0][j] = minDp[0][j - 1] * grid[0][j];
        }

        // Fill first column (can only come from top)
        for (int i = 1; i < m; i++) {
            maxDp[i][0] = maxDp[i - 1][0] * grid[i][0];
            minDp[i][0] = minDp[i - 1][0] * grid[i][0];
        }

        // Fill the rest of the table
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                long current = grid[i][j];

                // Get all possible products by combining with previous cells
                long fromTopMax = maxDp[i - 1][j] * current;
                long fromTopMin = minDp[i - 1][j] * current;
                long fromLeftMax = maxDp[i][j - 1] * current;
                long fromLeftMin = minDp[i][j - 1] * current;

                // Store best max and min for current cell
                maxDp[i][j] = Math.max(Math.max(fromTopMax, fromTopMin),
                        Math.max(fromLeftMax, fromLeftMin));
                minDp[i][j] = Math.min(Math.min(fromTopMax, fromTopMin),
                        Math.min(fromLeftMax, fromLeftMin));
            }
        }

        long result = maxDp[m - 1][n - 1];

        // If maximum product is negative, return -1
        if (result < 0) {
            return -1;
        }

        return (int) (result % MOD);
    }
}