class Solution {
    public long maximumScore(int[][] grid) {
        int n = grid.length;
        if (n == 1)
            return 0L;

        int M = n + 1; // possible values: -1 .. n-1 -> indices 0 .. n
        // prefix sums for each column
        long[][] ps = new long[n][n + 1];
        for (int j = 0; j < n; ++j) {
            for (int i = 0; i < n; ++i) {
                ps[j][i + 1] = ps[j][i] + grid[i][j];
            }
        }

        // dp[aIdx][bIdx] : a = aIdx-1, b = bIdx-1
        long[][] dp = new long[M][M];
        for (int i = 0; i < M; ++i)
            Arrays.fill(dp[i], Long.MIN_VALUE / 2);
        for (int bIdx = 0; bIdx < M; ++bIdx)
            dp[0][bIdx] = 0; // h_{-1} = -1

        // process columns 0 .. n-2
        for (int j = 0; j < n - 1; ++j) {
            long[][] newdp = new long[M][M];
            for (int i = 0; i < M; ++i)
                Arrays.fill(newdp[i], Long.MIN_VALUE / 2);

            for (int bIdx = 0; bIdx < M; ++bIdx) {
                int b = bIdx - 1;
                int low = b + 1;

                // prefix maximum of dp[a][b] over a (aIdx)
                long[] pref = new long[M];
                long curMax = Long.MIN_VALUE / 2;
                for (int aIdx = 0; aIdx < M; ++aIdx) {
                    curMax = Math.max(curMax, dp[aIdx][bIdx]);
                    pref[aIdx] = curMax;
                }

                // E[a] = dp[a][b] + A(a,b)
                long[] E = new long[M];
                for (int aIdx = 0; aIdx < M; ++aIdx) {
                    int a = aIdx - 1;
                    long A = 0;
                    if (low <= n - 1 && a >= low) {
                        A = ps[j][a + 1] - ps[j][low];
                    }
                    E[aIdx] = dp[aIdx][bIdx] + A;
                }

                // suffix maximum of E
                long[] suff = new long[M + 1];
                suff[M] = Long.MIN_VALUE / 2;
                for (int aIdx = M - 1; aIdx >= 0; --aIdx) {
                    suff[aIdx] = Math.max(E[aIdx], suff[aIdx + 1]);
                }

                for (int cIdx = 0; cIdx < M; ++cIdx) {
                    int c = cIdx - 1;
                    long B = 0;
                    long C = 0;
                    if (low <= n - 1 && c >= low) {
                        B = ps[j][c + 1] - ps[j][low];
                        C = B;
                    }
                    long best1 = pref[cIdx];
                    long best2 = (cIdx + 1 < M) ? suff[cIdx + 1] : Long.MIN_VALUE / 2;
                    if (best2 != Long.MIN_VALUE / 2)
                        best2 -= C;
                    long best = Math.max(best1, best2);
                    if (best != Long.MIN_VALUE / 2) {
                        newdp[bIdx][cIdx] = best + B;
                    }
                }
            }
            dp = newdp;
        }

        // last column (j = n-1)
        long ans = 0;
        for (int aIdx = 0; aIdx < M; ++aIdx) {
            for (int bIdx = 0; bIdx < M; ++bIdx) {
                long cur = dp[aIdx][bIdx];
                if (cur == Long.MIN_VALUE / 2)
                    continue;
                int a = aIdx - 1;
                int b = bIdx - 1;
                int low = b + 1;
                long add = 0;
                if (low <= n - 1 && a >= low) {
                    add = ps[n - 1][a + 1] - ps[n - 1][low];
                }
                ans = Math.max(ans, cur + add);
            }
        }
        return ans;
    }
}