class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] result = new int[m * n];
        int index = 0;
        
        // Iterate through all m + n - 1 diagonals
        for (int d = 0; d < m + n - 1; d++) {
            
            if (d % 2 == 0) {
                // EVEN diagonal: Go UP-RIGHT 
                // Start from bottom-left of diagonal
                int row = (d < m) ? d : m - 1;
                int col = (d < m) ? 0 : d - m + 1;
                
                // Move up-right until boundary
                while (row >= 0 && col < n) {
                    result[index++] = mat[row][col];
                    row--;  // go up
                    col++;  // go right
                }
            } else {
                // ODD diagonal: Go DOWN-LEFT ↙️
                // Start from top-right of diagonal
                int col = (d < n) ? d : n - 1;
                int row = (d < n) ? 0 : d - n + 1;
                
                // Move down-left until boundary
                while (row < m && col >= 0) {
                    result[index++] = mat[row][col];
                    row++;  // go down
                    col--;  // go left
                }
            }
        }
        
        return result;
    }
}
