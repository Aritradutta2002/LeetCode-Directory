class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int row_limit = x + k / 2;
        int col_limit = y + k;
        for (int i = x; i < row_limit; i++) {
            for (int j = y; j < col_limit; j++) {
                int mirrorRow = x + k - 1 - (i - x);
                swap(grid, i, j, mirrorRow, j);
            }
        }
        return grid;
    }

    public void swap(int[][] grid, int i, int j, int x, int y) {
        int temp = grid[i][j];
        grid[i][j] = grid[x][y];
        grid[x][y] = temp;
    }
}
