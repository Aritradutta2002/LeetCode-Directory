class Solution {
    public int maximumAmount(int[][] coins) {
        int n = coins.length;
        int m = coins[0].length;
        Long[][][] memo = new Long[n][m][3];
        return (int) dfs(0, 0, n, m, coins, memo, 2);
    }

    public static long dfs(int i, int j, int n, int m, int[][] coins, Long[][][] memo, int k) {
        if (i >= n || j >= m) {
            return Long.MIN_VALUE / 2;
        }

        if (i == n - 1 && j == m - 1) {
            if (coins[i][j] < 0 && k > 0) {
                return 0;
            }
            return coins[i][j];
        }

        if (memo[i][j][k] != null) {
            return memo[i][j][k];
        }

        long currentVal = coins[i][j];

        long takeMove = currentVal + Math.max(
                dfs(i + 1, j, n, m, coins, memo, k),
                dfs(i, j + 1, n, m, coins, memo, k));

        long neutralizeMove = Long.MIN_VALUE / 2;
        if (currentVal < 0 && k > 0) {
            neutralizeMove = 0 + Math.max(
                    dfs(i + 1, j, n, m, coins, memo, k - 1),
                    dfs(i, j + 1, n, m, coins, memo, k - 1));
        }

        return memo[i][j][k] = Math.max(takeMove, neutralizeMove);
    }
}