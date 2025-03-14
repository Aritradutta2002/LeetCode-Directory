class Solution {
public:
    vector<vector<string>>ans;
    int N;
    bool isSafe(vector<string>&board,int row,int col){
        for(int i=row;i>=0;i--){
            if(board[i][col]=='Q') return false;
        }
        for(int i=row,j=col;i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q') return false;
        }
        for(int i=row,j=col;i>=0 && j<N;i--,j++){
            if(board[i][j]=='Q') return false;
        }
        return true;
    }
    void solve(vector<string>&board,int row){
        if(row==N){
            ans.push_back(board);
            return;
        }
        for(int col=0;col<N;col++){
            if(isSafe(board,row,col)){
                board[row][col]='Q';
                solve(board,row+1);
                board[row][col]='.';
            }
        }
    }
    vector<vector<string>> solveNQueens(int n) {
        if(n==0) return {};
        N=n;
        vector<string>board(n,string(n,'.'));
        solve(board,0);
        return ans;
    }
};