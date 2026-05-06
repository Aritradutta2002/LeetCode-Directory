class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length, n = boxGrid[0].length;

        for (char[] row : boxGrid) {
            int empty = n - 1;
            for (int col = n - 1; col >= 0; col--) {
                if (row[col] == '*') {
                    empty = col - 1;
                } else if (row[col] == '#') {
                    row[col] = '.';
                    row[empty] = '#';
                    empty--;
                }
            }
        }

        char[][] result = new char[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[j][m - i - 1] = boxGrid[i][j];
            }
        }

        return result;
    }
}