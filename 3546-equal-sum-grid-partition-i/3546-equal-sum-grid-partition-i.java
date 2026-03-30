class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        long[] rowPS = new long[n + 1];
        long[] colPS = new long[m + 1];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                rowPS[i + 1] += grid[i][j];
                colPS[j + 1] += grid[i][j];
            }

        for (int i = 1; i <= n; i++)
            rowPS[i] += rowPS[i - 1];
        for (int j = 1; j <= m; j++)
            colPS[j] += colPS[j - 1];

        long total = rowPS[n];
        if (total % 2 != 0)
            return false;
        long half = total / 2;

        if (Arrays.binarySearch(rowPS, 1, n, half) >= 0)
            return true;
        if (Arrays.binarySearch(colPS, 1, m, half) >= 0)
            return true;

        return false;
    }
}