class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int top = x;
        int bottom = x + k - 1;
        int colEnd = y + k;

        while (top < bottom) {
            for (int col = y; col < colEnd; col++) {
                swap(grid, top, col, bottom, col);
            }
            top++;
            bottom--;
        }
        return grid;
    }

    public void swap(int[][] grid, int r1, int c1, int r2, int c2) {
        int temp = grid[r1][c1];
        grid[r1][c1] = grid[r2][c2];
        grid[r2][c2] = temp;
    }

}