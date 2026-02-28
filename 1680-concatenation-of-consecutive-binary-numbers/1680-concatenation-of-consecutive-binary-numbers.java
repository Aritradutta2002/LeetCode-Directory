class Solution {
    static final int MOD = 1_000_000_007;

    public int concatenatedBinary(int n) {
        long ans = 0;
        int bitLen = 0;

        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0)
                bitLen++;
            ans = ((ans << bitLen) | i) % MOD;
        }

        return (int) ans;
    }
}