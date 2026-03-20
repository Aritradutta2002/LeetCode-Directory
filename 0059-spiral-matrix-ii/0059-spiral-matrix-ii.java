class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int left = 0, right = n - 1;
        int top = 0, bottom = n - 1;
        int val = 1;

        while (left <= right && top <= bottom) {
            for (int c = left; c <= right; c++) {
                ans[top][c] = val++;
            }
            top++;

            for (int r = top; r <= bottom; r++) {
                ans[r][right] = val++;
            }
            right--;

            if (top <= bottom) {
                for (int c = right; c >= left; c--) {
                    ans[bottom][c] = val++;
                }
                bottom--;
            }

            if (left <= right) {
                for (int r = bottom; r >= top; r--) {
                    ans[r][left] = val++;
                }
                left++;
            }
        }

        return ans;
    }
}
