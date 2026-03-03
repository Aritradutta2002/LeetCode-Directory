class Solution {
    private static final int INF = (int) 1e9;

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        for (int t = 0; t <= amount; t++) {
            if (t % coins[0] == 0)
                dp[0][t] = t / coins[0];
            else
                dp[0][t] = INF;
        }

        for (int i = 1; i < n; i++) {
            for (int t = 0; t <= amount; t++) {
                int notTake = dp[i - 1][t];
                int take = INF;
                if (coins[i] <= t && dp[i][t - coins[i]] != INF) {
                    take = 1 + dp[i][t - coins[i]];
                }
                dp[i][t] = Math.min(notTake, take);
            }
        }

        return dp[n - 1][amount] >= INF ? -1 : dp[n - 1][amount];
    }
}