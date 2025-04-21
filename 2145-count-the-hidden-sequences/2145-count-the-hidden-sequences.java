class Solution {
    public static int numberOfArrays(int[] differences, int lower, int upper) {
        int n = differences.length;
        long[] prefixSum = new long[n + 1];
        prefixSum[0] = 0;
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + differences[i - 1];
        }
        long minPrefix = Long.MAX_VALUE;
        long maxPrefix = Long.MIN_VALUE;
        for (int i = 0; i <= n; i++) {
            minPrefix = Math.min(minPrefix, prefixSum[i]);
            maxPrefix = Math.max(maxPrefix, prefixSum[i]);
        }
        long minValue = lower - minPrefix;
        long maxValue = upper - maxPrefix;
        if (minValue > maxValue) {
            return 0;
        }
        return (int) (maxValue - minValue + 1);
    }
}