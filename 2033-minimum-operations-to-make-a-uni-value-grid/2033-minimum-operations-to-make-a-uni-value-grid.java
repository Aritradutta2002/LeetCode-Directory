class Solution {
    public int minOperations(int[][] grid, int x) {
        int n = grid.length;
        int m = grid[0].length;
        int[] arr = new int[n * m];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[idx++] = grid[i][j];
            }
        }
        int mod = arr[0] % x;
        for (int i : arr) {
            if (i % x != mod) {
                return -1;
            }
        }
        Arrays.sort(arr);
        int median = arr[(n * m) / 2];
        int ops = 0;
        for (int v : arr) {
            ops += Math.abs(v - median) / x;
        }
        return (int) ops;
    }
}