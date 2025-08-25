class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        // If the grid is empty, just return an empty answer.
        if (mat == null || mat.length == 0) {
            return new int[0];
        }

        // Get the height (number of rows) and width (number of columns) of the grid.
        int m = mat.length;
        int n = mat[0].length;

        // This is our final answer list. It needs to be big enough to hold every number.
        int[] result = new int[m * n];
        
        // We'll start our walk at the top-left corner, which is row 0, column 0.
        int row = 0, col = 0;

        // We need to loop enough times to visit every single number in the grid.
        for (int i = 0; i < m * n; i++) {
            // First, add the number at our current spot to our answer list.
            result[i] = mat[row][col];

            // Now, we need to figure out where to walk next.

            // If (row + col) is an EVEN number, we are moving UP and RIGHT.
            if ((row + col) % 2 == 0) { 
                // If we hit the RIGHT wall... we must move DOWN one step.
                if (col == n - 1) {
                    row++;
                // If we hit the TOP wall... we must move RIGHT one step.
                } else if (row == 0) {
                    col++;
                // If we are not at a wall, just move diagonally UP and RIGHT.
                } else {
                    row--;
                    col++;
                }
            } else { // If (row + col) is an ODD number, we are moving DOWN and LEFT.
                // If we hit the BOTTOM wall... we must move RIGHT one step.
                if (row == m - 1) {
                    col++;
                // If we hit the LEFT wall... we must move DOWN one step.
                } else if (col == 0) {
                    row++;
                // If we are not at a wall, just move diagonally DOWN and LEFT.
                } else {
                    row++;
                    col--;
                }
            }
        }
        
        // Once the loop is done, we have visited all the numbers in the right order!
        return result;
    }
}