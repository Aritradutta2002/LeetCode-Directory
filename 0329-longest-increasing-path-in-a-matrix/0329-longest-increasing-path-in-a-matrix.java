class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int longestPath = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int path = dfs(matrix, n, m, i, j);
                longestPath = Math.max(longestPath, path);
            }
        }
        return longestPath;
    }

    public int dfs(int[][] matrix, int n, int m, int i, int j) {
        int path = 0;
        int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        for (int[] d : dir) {
            int x = i + d[0];
            int y = j + d[1];
            if (x >= 0 && x < n && y >= 0 && y < m && matrix[x][y] > matrix[i][j]) {
                path = Math.max(path, dfs(matrix, n, m, x, y));
            }
        }
        return path + 1;
    }
}