import java.util.*;

class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer> array = new ArrayList<>();
        int remainder = grid[0][0] % x;

        // Step-1: Insert array elements
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] % x != remainder) {
                    return -1;
                }
                array.add(grid[i][j]);
            }
        }


        Collections.sort(array);
        int n = array.size();
        int median = n / 2;

        int steps = 0;
        for (int i = 0; i < n; ++i) {
            steps += Math.abs(array.get(i) - array.get(median)) / x;
        }

        return steps;
    }
}