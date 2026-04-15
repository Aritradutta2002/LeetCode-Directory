class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, (a, b) -> Integer.compare(a[0], b[0]));

        int n = robot.size();
        int m = factory.length;

        // dp[i][j] = min distance using first i factories to repair first j robots
        long[][] dp = new long[m + 1][n + 1];

        // Initialize with a large value
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], Long.MAX_VALUE / 2);
        }

        // Base case: 0 robots fixed with any number of factories cost 0
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= m; i++) {
            int factoryPos = factory[i - 1][0];
            int factoryLimit = factory[i - 1][1];

            for (int j = 0; j <= n; j++) {
                // Option 1: Current factory repairs 0 robots
                dp[i][j] = dp[i - 1][j];

                // Option 2: Current factory repairs k robots (1 <= k <= limit)
                long currentDistance = 0;
                for (int k = 1; k <= factoryLimit && j - k >= 0; k++) {
                    currentDistance += Math.abs((long) robot.get(j - k) - factoryPos);
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - k] + currentDistance);
                }
            }
        }

        return dp[m][n];
    }
}