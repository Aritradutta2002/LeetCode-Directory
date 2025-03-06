import java.util.*;

class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int totalNumbers = n * n;
        Set<Integer> set = new HashSet<>();
        int repeated = -1;
        int actualSum = 0;

        for (int[] row : grid) {
            for (int num : row) {
                if (set.contains(num)) {
                    repeated = num;
                } else {
                    set.add(num);
                }
                actualSum += num;
            }
        }

        int expectedSum = totalNumbers * (totalNumbers + 1) / 2;
        int missing = expectedSum - (actualSum - repeated);

        return new int[]{repeated, missing};
    }
}