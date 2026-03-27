class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int n = mat.length;
        int m = mat[0].length;
        k = k % m;
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][((j + k) % m)] = mat[i][j];
            }
        }
        return isEqualGrid(grid, mat);
    }

    public boolean isEqualGrid(int[][] grid, int[][] mat) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != mat[i][j])
                    return false;
            }
        }
        return true;
    }

}