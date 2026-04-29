class Solution {
    public long maximumScore(int[][] grid) {
        int n = grid.length;

        long[][] colSum = new long[n][n];
        for (int j = 0; j < n; j++) {
            colSum[j][0] = grid[0][j];
            for (int i = 1; i < n; i++)
                colSum[j][i] = colSum[j][i - 1] + grid[i][j];
        }

        final long NEG = Long.MIN_VALUE / 4;
        long[][] dp = new long[n + 1][n + 1];
        for (long[] row : dp)
            Arrays.fill(row, NEG);
        for (int b = 0; b <= n; b++)
            dp[0][b] = 0;

        for (int j = 0; j < n - 1; j++) {
            long[][] ndp = new long[n + 1][n + 1];
            for (long[] row : ndp)
                Arrays.fill(row, NEG);

            for (int b = 0; b <= n; b++) {
                long base = b > 0 ? colSum[j][b - 1] : 0;

                long[] g = new long[n + 1];
                for (int a = 0; a <= n; a++) {
                    int m = a - 1;
                    g[a] = dp[a][b] + (m >= b ? colSum[j][m] - base : 0);
                }

                long[] suf = new long[n + 1];
                suf[n] = g[n];
                for (int i = n - 1; i >= 0; i--)
                    suf[i] = Math.max(g[i], suf[i + 1]);

                long[] pre = new long[n + 1];
                pre[0] = NEG;
                for (int i = 1; i <= n; i++)
                    pre[i] = Math.max(pre[i - 1], dp[i - 1][b]);

                for (int c = 0; c <= n; c++) {
                    long v1 = suf[c];
                    int m = c - 1;
                    long p = m >= b ? colSum[j][m] - base : 0;
                    ndp[b][c] = Math.max(v1, p + pre[c]);
                }
            }
            dp = ndp;
        }

        long ans = 0;
        for (int a = 0; a <= n; a++) {
            for (int b = 0; b <= n; b++) {
                if (dp[a][b] <= NEG / 2)
                    continue;
                int da = a - 1, db = b - 1, lo = db + 1;
                long add = 0;
                if (da >= 0 && lo <= da) {
                    int hi = Math.min(da, n - 1);
                    add = colSum[n - 1][hi] - (lo > 0 ? colSum[n - 1][lo - 1] : 0);
                }
                ans = Math.max(ans, dp[a][b] + add);
            }
        }
        return ans;
    }
}