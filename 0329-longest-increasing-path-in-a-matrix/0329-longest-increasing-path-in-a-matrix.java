class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int[][] memo = new int[rows][cols];
        int result = 0;

        for (int r = 0; r < rows; r++)
            for (int c = 0; c < cols; c++)
                result = Math.max(result, dfs(r, c, matrix, memo, -1));

        return result;
    }

    public int dfs(int r, int c, int[][] matrix, int[][] memo, int prev) {
        // Out of bounds OR not strictly increasing
        if (r < 0 || r >= matrix.length || c < 0 || c >= matrix[0].length)
            return 0;
        if (matrix[r][c] <= prev)
            return 0;

        // Return cached result
        if (memo[r][c] != 0)
            return memo[r][c];

        int best = 0;
        best = Math.max(best, dfs(r + 1, c, matrix, memo, matrix[r][c]));
        best = Math.max(best, dfs(r - 1, c, matrix, memo, matrix[r][c]));
        best = Math.max(best, dfs(r, c + 1, matrix, memo, matrix[r][c]));
        best = Math.max(best, dfs(r, c - 1, matrix, memo, matrix[r][c]));

        memo[r][c] = 1 + best; // 1 for the current cell
        return memo[r][c];
    }
}