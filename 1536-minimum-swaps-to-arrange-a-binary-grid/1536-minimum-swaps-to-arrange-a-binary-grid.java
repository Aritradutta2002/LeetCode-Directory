class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] lastOne = new int[n];
        for (int row = 0; row < n; row++) {
            lastOne[row] = -1;
            for (int col = n - 1; col >= 0; col--) {
                if (grid[row][col] == 1) {
                    lastOne[row] = col;
                    break; 
                }
            }
        }

        int totalSwaps = 0;

        for (int i = 0; i < n; i++) {

            int validRow = -1;
            for (int k = i; k < n; k++) {
                if (lastOne[k] <= i) {
                    validRow = k;
                    break;
                }
            }

            if (validRow == -1) return -1;

            totalSwaps += validRow - i;

            for (int j = validRow; j > i; j--) {
                int temp   = lastOne[j];
                lastOne[j] = lastOne[j - 1];
                lastOne[j - 1] = temp;
            }
        }

        return totalSwaps;
    }
}