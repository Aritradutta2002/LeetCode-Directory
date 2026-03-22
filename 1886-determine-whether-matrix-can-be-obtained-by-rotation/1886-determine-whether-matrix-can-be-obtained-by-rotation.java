class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int[][] cur = mat;
        for (int k = 0; k < 4; k++) {
            if (same(cur, target)) {
                return true;
            }
            cur = rotate90Clockwise(cur);
        }
        return false;
    }

    private static boolean same(int[][] a, int[][] b) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] != b[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int[][] rotate90Clockwise(int[][] in) {
        int n = in.length;
        int[][] out = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                out[j][n - 1 - i] = in[i][j];
            }
        }
        return out;
    }
}