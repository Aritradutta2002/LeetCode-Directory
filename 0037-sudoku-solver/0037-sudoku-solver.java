class Solution {
    public static void solveSudoku(char[][] board) {
        solveSudokuAns(board);
    }

    public static boolean isValidSudoku(char[][] board, int row, int col, int num) {
        for(int i = 0; i < 9; i++){
            if(board[row][i] == num){
                return false;
            }
        }

        for(int j = 0; j < 9; j++){
            if(board[j][col] == num){
                return false;
            }
        }

        int startRow = row - row % 3;
        int startCol = col - col % 3;

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(board[startRow + i][startCol + j] == num){
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean solveSudokuAns(char[][] board) {
        int n = board.length;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (board[row][col] == '.') {
                    for (char num = '1'; num <= '9'; num++) {
                        if (isValidSudoku(board, row, col, num)) {
                            board[row][col] = num;

                            if (solveSudokuAns(board)) {
                                return true;
                            }

                            board[row][col] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

}