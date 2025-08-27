class Solution {
    public int lenOfVDiagonal(int[][] grid) {
        int rows = grid.length;        // Number of rows
        int cols = grid[0].length;     // Number of columns
        int maxLength = 0;             // Track the longest path found
        
        // Try starting from every cell that contains value 1
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 1) {  // Only start from cells with value 1
                    // Try all 4 diagonal directions from this starting point
                    int length1 = exploreVPath(grid, row, col, 1, 1);    // Southeast
                    int length2 = exploreVPath(grid, row, col, -1, -1);  // Northwest
                    int length3 = exploreVPath(grid, row, col, 1, -1);   // Southwest  
                    int length4 = exploreVPath(grid, row, col, -1, 1);   // Northeast
                    
                    // Keep track of the maximum length found
                    maxLength = Math.max(maxLength, length1);
                    maxLength = Math.max(maxLength, length2);
                    maxLength = Math.max(maxLength, length3);
                    maxLength = Math.max(maxLength, length4);
                }
            }
        }
        
        return maxLength;
    }
    
    /**
     * Explores a V-shaped path starting from given position in given direction
     */
    private int exploreVPath(int[][] grid, int startRow, int startCol, int deltaRow, int deltaCol) {
        int rows = grid.length;
        int cols = grid[0].length;
        int maxLength = 0;
        
        // Step 1: Go as far as possible in the initial direction
        int currentRow = startRow;
        int currentCol = startCol;
        int pathLength = 1;  // Start counting from 1 (the starting cell)
        
        // Keep moving in initial direction while pattern matches
        while (true) {
            int nextRow = currentRow + deltaRow;
            int nextCol = currentCol + deltaCol;
            
            // Check if next position is within grid bounds
            if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols) {
                break;  // Out of bounds, stop exploring this direction
            }
            
            // Check if the value matches expected pattern
            int expectedValue = getExpectedValue(pathLength);
            if (grid[nextRow][nextCol] != expectedValue) {
                break;  // Pattern doesn't match, stop exploring
            }
            
            // Move to next position and increase path length
            currentRow = nextRow;
            currentCol = nextCol;
            pathLength++;
        }
        
        maxLength = pathLength;  // Record length without any turns
        
        // Step 2: Try making a clockwise turn at each possible position
        for (int turnPosition = 0; turnPosition < pathLength; turnPosition++) {
            // Calculate position where we make the turn
            int turnRow = startRow + turnPosition * deltaRow;
            int turnCol = startCol + turnPosition * deltaCol;
            
            // Get new direction after clockwise turn
            int[] newDirection = getClockwiseTurn(deltaRow, deltaCol);
            int newDeltaRow = newDirection[0];
            int newDeltaCol = newDirection[1];
            
            // Continue exploring from turn position in new direction
            int currRow = turnRow;
            int currCol = turnCol;
            int currLength = turnPosition + 1;  // Length up to turn point
            
            // Keep moving in new direction while pattern matches
            while (true) {
                int nextRow = currRow + newDeltaRow;
                int nextCol = currCol + newDeltaCol;
                
                // Check bounds
                if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols) {
                    break;
                }
                
                // Check pattern
                int expectedValue = getExpectedValue(currLength);
                if (grid[nextRow][nextCol] != expectedValue) {
                    break;
                }
                
                currRow = nextRow;
                currCol = nextCol;
                currLength++;
            }
            
            // Update maximum length if this path is longer
            maxLength = Math.max(maxLength, currLength);
        }
        
        return maxLength;
    }
    
    /**
     * Returns the expected value at given index in the pattern
     * Pattern: 1, 2, 0, 2, 0, 2, 0...
     */
    private int getExpectedValue(int index) {
        if (index == 0) {
            return 1;           // First element is always 1
        } else if (index % 2 == 1) {
            return 2;           // Odd positions have value 2
        } else {
            return 0;           // Even positions (except 0) have value 0
        }
    }
    
    /**
     * Returns new direction after making a clockwise 90-degree turn
     */
    private int[] getClockwiseTurn(int deltaRow, int deltaCol) {
        // Clockwise turn mapping:
        // Southeast (1,1) -> Southwest (1,-1)
        // Southwest (1,-1) -> Northwest (-1,-1)  
        // Northwest (-1,-1) -> Northeast (-1,1)
        // Northeast (-1,1) -> Southeast (1,1)
        
        if (deltaRow == 1 && deltaCol == 1) {      // SE -> SW
            return new int[]{1, -1};
        } else if (deltaRow == 1 && deltaCol == -1) {  // SW -> NW
            return new int[]{-1, -1};
        } else if (deltaRow == -1 && deltaCol == -1) { // NW -> NE
            return new int[]{-1, 1};
        } else {  // NE -> SE (deltaRow == -1 && deltaCol == 1)
            return new int[]{1, 1};
        }
    }
}

// Test the solution with sample cases
public class TestSolution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test Case 1
        int[][] grid1 = {
            {2,2,1,2,2},
            {2,0,2,2,0},
            {2,0,1,1,0},
            {1,0,2,2,2},
            {2,0,0,2,2}
        };
        System.out.println("Test 1 - Expected: 5, Got: " + solution.lenOfVDiagonal(grid1));
        
        // Test Case 2
        int[][] grid2 = {
            {2,2,2,2,2},
            {2,0,2,2,0},
            {2,0,1,1,0},
            {1,0,2,2,2},
            {2,0,0,2,2}
        };
        System.out.println("Test 2 - Expected: 4, Got: " + solution.lenOfVDiagonal(grid2));
        
        // Test Case 3
        int[][] grid3 = {
            {1,2,2,2,2},
            {2,2,2,2,0},
            {2,0,0,0,0},
            {0,0,2,2,2},
            {2,0,0,2,0}
        };
        System.out.println("Test 3 - Expected: 5, Got: " + solution.lenOfVDiagonal(grid3));
        
        // Test Case 4 - Single cell
        int[][] grid4 = {{1}};
        System.out.println("Test 4 - Expected: 1, Got: " + solution.lenOfVDiagonal(grid4));
    }
}