class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;
        int totalElements = rows * cols;
        k %= totalElements;
        if (k < 0) {
            k += totalElements;
        }

        List<Integer> flat = new ArrayList<>(totalElements);
        for (int[] row : grid) {
            for (int value : row) {
                flat.add(value);
            }
        }

        List<Integer> shifted = new ArrayList<>(totalElements);
        for (int i = 0; i < totalElements; i++) {
            shifted.add(flat.get((i - k + totalElements) % totalElements));
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            List<Integer> row = new ArrayList<>(cols);
            for (int j = 0; j < cols; j++) {
                row.add(shifted.get(i * cols + j));
            }
            result.add(row);
        }
        return result;
    }
}