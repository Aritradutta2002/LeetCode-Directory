class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        long[] rowPS = new long[n + 1];
        long[] colPS = new long[m + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rowPS[i + 1] += grid[i][j];
                colPS[j + 1] += grid[i][j];
            }
        }

        for (int i = 1; i <= n; i++)
            rowPS[i] += rowPS[i - 1];
        for (int j = 1; j <= m; j++)
            colPS[j] += colPS[j - 1];

        long total = rowPS[n];
        if (total % 2 != 0)
            return false;
        long half = total / 2;

        for (int i = 1; i < n; i++)
            if (rowPS[i] == half)
                return true;
        for (int j = 1; j < m; j++)
            if (colPS[j] == half)
                return true;

        return false;
    }
}