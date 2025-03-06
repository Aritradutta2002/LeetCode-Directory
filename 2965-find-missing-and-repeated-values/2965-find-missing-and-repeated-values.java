class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        Set<Integer> set = new HashSet<>();
        int repeated = 0;
        int sumWithoutRepeated = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(set.contains(grid[i][j])){
                    repeated = grid[i][j];
                }
                else{
                    set.add(grid[i][j]);
                    sumWithoutRepeated += grid[i][j];
                }
            }
        }

         int gridSum = (n * n * (n * n + 1)) / 2;
        int missing = gridSum - sumWithoutRepeated;

        return new int[] {repeated, missing};
    }
}