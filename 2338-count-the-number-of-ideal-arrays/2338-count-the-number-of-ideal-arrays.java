class Solution {
    private static final int MOD = (int) 1e9 + 7;
    private int[][] memo;
    private int[][] combinations;
    private int numElements;
    private int maxVal;

    public int idealArrays(int n, int maxValue) {
        numElements = n;
        maxVal = maxValue;
        memo = new int[maxVal + 1][16];
        for (int i = 0; i <= maxVal; i++) {
            for (int j = 0; j < 16; j++) {
                memo[i][j] = -1;
            }
        }
        combinations = new int[n][16];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i && j < 16; j++) {
                if (j == 0) {
                    combinations[i][j] = 1;
                } else {
                    combinations[i][j] = (combinations[i - 1][j] + combinations[i - 1][j - 1]) % MOD;
                }
            }
        }
        int totalCount = 0;
        for (int startVal = 1; startVal <= maxVal; startVal++) {
            totalCount = (totalCount + countArrays(startVal, 1)) % MOD;
        }
        return totalCount;
    }

    private int countArrays(int currentVal, int currentLength) {
        if (memo[currentVal][currentLength] != -1) {
            return memo[currentVal][currentLength];
        }
        int ways = combinations[numElements - 1][currentLength - 1];
        if (currentLength < numElements) {
            for (int multiple = 2; currentVal * multiple <= maxVal; multiple++) {
                ways = (ways + countArrays(currentVal * multiple, currentLength + 1)) % MOD;
            }
        }
        memo[currentVal][currentLength] = ways;
        return ways;
    }
}