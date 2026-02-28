class Solution {
    static final int MOD = 1_000_000_007;
    public int concatenatedBinary(int n) {
        StringBuilder binary = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            binary.append(Integer.toBinaryString(i));
        }

        long ans = 0;
        for (int i = 0; i < binary.length(); i++) {
            ans = (ans * 2 + (binary.charAt(i) - '0')) % MOD;
        }
        return (int) ans;
    }
}