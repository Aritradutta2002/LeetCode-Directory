public class Solution {
    public int lenOfVDiagonal(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int maxLength = 0;
        
        // Try starting from every cell that contains value 1
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 1) {
                    // Try all 4 diagonal directions from this starting point
                    int length1 = exploreVPath(grid, row, col, 1, 1);    // Southeast
                    int length2 = exploreVPath(grid, row, col, -1, -1);  // Northwest
                    int length3 = exploreVPath(grid, row, col, 1, -1);   // Southwest  
                    int length4 = exploreVPath(grid, row, col, -1, 1);   // Northeast
                    
                    maxLength = Math.max(maxLength, length1);
                    maxLength = Math.max(maxLength, length2);
                    maxLength = Math.max(maxLength, length3);
                    maxLength = Math.max(maxLength, length4);
                }
            }
        }
        
        return maxLength;
    }
    
    private int exploreVPath(int[][] grid, int startRow, int startCol, int deltaRow, int deltaCol) {
        int rows = grid.length;
        int cols = grid[0].length;
        int maxLength = 0;
        
        // Step 1: Go as far as possible in initial direction
        int currentRow = startRow;
        int currentCol = startCol;
        int pathLength = 1;
        
        while (true) {
            int nextRow = currentRow + deltaRow;
            int nextCol = currentCol + deltaCol;
            
            if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols) {
                break;
            }
            
            int expectedValue = getExpectedValue(pathLength);
            if (grid[nextRow][nextCol] != expectedValue) {
                break;
            }
            
            currentRow = nextRow;
            currentCol = nextCol;
            pathLength++;
        }
        
        maxLength = pathLength;
        
        // Step 2: Try making clockwise turns at each position
        for (int turnPosition = 0; turnPosition < pathLength; turnPosition++) {
            int turnRow = startRow + turnPosition * deltaRow;
            int turnCol = startCol + turnPosition * deltaCol;
            
            int[] newDirection = getClockwiseTurn(deltaRow, deltaCol);
            int newDeltaRow = newDirection[0];
            int newDeltaCol = newDirection[1];
            
            int currRow = turnRow;
            int currCol = turnCol;
            int currLength = turnPosition + 1;
            
            while (true) {
                int nextRow = currRow + newDeltaRow;
                int nextCol = currCol + newDeltaCol;
                
                if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols) {
                    break;
                }
                
                int expectedValue = getExpectedValue(currLength);
                if (grid[nextRow][nextCol] != expectedValue) {
                    break;
                }
                
                currRow = nextRow;
                currCol = nextCol;
                currLength++;
            }
            
            maxLength = Math.max(maxLength, currLength);
        }
        
        return maxLength;
    }
    
    private int getExpectedValue(int index) {
        if (index == 0) {
            return 1;
        } else if (index % 2 == 1) {
            return 2;
        } else {
            return 0;
        }
    }
    
    private int[] getClockwiseTurn(int deltaRow, int deltaCol) {
        if (deltaRow == 1 && deltaCol == 1) {
            return new int[]{1, -1};
        } else if (deltaRow == 1 && deltaCol == -1) {
            return new int[]{-1, -1};
        } else if (deltaRow == -1 && deltaCol == -1) {
            return new int[]{-1, 1};
        } else {
            return new int[]{1, 1};
        }
    }
}
