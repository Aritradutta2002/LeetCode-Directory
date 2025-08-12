class Solution {
    public int numberOfWays(int n, int x) {
        final int MOD = 1_000_000_007;
        
        int[] dp = new int[n + 1];
        dp[0] = 1;

        int num = 1;
        while (true) {
            int power = (int) Math.pow(num, x);

            if (power > n) {
                break;
            }

            for (int j = n; j >= power; j--) {
                dp[j] = (dp[j] + dp[j - power]) % MOD;
            }
            
            num++;
        }

        return dp[n];
    }
}