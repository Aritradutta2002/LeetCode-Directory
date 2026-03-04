class Solution {
    public int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] row = new int[m];
        int[] col = new int[n];

        /* Marking the 1 containing row and columns */
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    row[i]++;
                    col[j]++;
                }
            }
        }

        /* Now checking more than one 1 have or not */
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((row[i] == 1) && (col[j] == 1) && (mat[i][j] == 1)) {
                    count++;
                }
            }
        }

        return count;

    }

}