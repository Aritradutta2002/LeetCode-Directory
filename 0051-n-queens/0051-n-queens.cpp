class Solution {
public:
    vector<vector<string>> solveNQueens(int n) {
         vector<vector<int>> placements = NQueensInt(n);
        return convertToBoard(n, placements);
    }

    bool IsValid(const vector<int> &col_placement) {
    int row_id = col_placement.size() - 1;
    for (int i = 0; i < row_id; ++i) {
        int diff = abs(col_placement[i] - col_placement[row_id]);
        if (diff == 0 || diff == row_id - i) {
            return false;
        }
    }
    return true;
}

void solveNQueen(int n, int row, vector<int> &col_placement, vector<vector<int>> &result) {
    if (row == n) {
        result.push_back(col_placement);
    } else {
        for (int col = 0; col < n; ++col) {
            col_placement.push_back(col);
            if (IsValid(col_placement)) {
                solveNQueen(n, row + 1, col_placement, result);
            }
            col_placement.pop_back();
        }
    }
}

vector<vector<int>> NQueensInt(int n) {
    vector<vector<int>> result;
    vector<int> col_placement;
    solveNQueen(n, 0, col_placement, result);
    return result;
}

vector<vector<string>> convertToBoard(int n, const vector<vector<int>> &placements) {
    vector<vector<string>> boardSolutions;
    for (auto &solution : placements) {
        vector<string> board;
        for (int i = 0; i < n; i++) {
            string row(n, '.');
            row[solution[i]] = 'Q';
            board.push_back(row);
        }
        boardSolutions.push_back(board);
    }
    return boardSolutions;
}
};