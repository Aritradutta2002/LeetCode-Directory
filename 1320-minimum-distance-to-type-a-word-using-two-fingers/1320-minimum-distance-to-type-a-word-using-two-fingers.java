class Solution {
    public int minimumDistance(String word) {
        int n = word.length();
        int[][][] dp = new int[n + 1][26][26];
        for (int i = 0; i <= n; i++)
            for (int f1 = 0; f1 < 26; f1++)
                for (int f2 = 0; f2 < 26; f2++)
                    dp[i][f1][f2] = Integer.MAX_VALUE;

        for (int f1 = 0; f1 < 26; f1++)
            for (int f2 = 0; f2 < 26; f2++)
                dp[0][f1][f2] = 0;

        for (int i = 1; i <= n; i++) {
            char c = word.charAt(i - 1);
            int cur = c - 'A';
            for (int f1 = 0; f1 < 26; f1++) {
                for (int f2 = 0; f2 < 26; f2++) {
                    if (dp[i - 1][f1][f2] == Integer.MAX_VALUE)
                        continue;
                    dp[i][cur][f2] = Math.min(dp[i][cur][f2], dp[i - 1][f1][f2] + dist(f1, cur));
                    dp[i][f1][cur] = Math.min(dp[i][f1][cur], dp[i - 1][f1][f2] + dist(f2, cur));
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int f1 = 0; f1 < 26; f1++)
            for (int f2 = 0; f2 < 26; f2++)
                ans = Math.min(ans, dp[n][f1][f2]);
        return ans;
    }

    private int dist(int a, int b) {
        int[] posA = getPos(a);
        int[] posB = getPos(b);
        return Math.abs(posA[0] - posB[0]) + Math.abs(posA[1] - posB[1]);
    }

    private int[] getPos(int idx) {
        int row = idx / 6;
        int col = idx % 6;
        return new int[] { row, col };
    }
}