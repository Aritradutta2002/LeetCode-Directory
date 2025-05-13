class Solution {
    public int lengthAfterTransformations(String s, int t) {
        final int MOD =  1_000_000_007;
        int[] dp = new int[26];
        for (char c : s.toCharArray()) {
            dp[c - 'a']++;
        }
        for (int step = 0; step < t; step++) {
            int[] next = new int[26];
            for(int i = 0; i < 25; i++) {
                next[i + 1] = dp[i];
            }
            next[0] = (next[0] + dp[25]) % MOD;
            next[1] = (next[1] + dp[25]) % MOD;
            dp = next;
        }
        long ans = 0;
        for (int cnt : dp) {
            ans = (ans + cnt) % MOD;
        }
        return (int) ans;
    }
}