class Solution {
public:
    void DirectedPermutations(int i, vector<int> *A_ptr, vector<vector<int>> *result) {
    vector<int> &A = *A_ptr;
    
    if (i == A.size() - 1) {
        result->emplace_back(A);
        return;
    }

    
    for (int j = i; j < A.size(); ++j) {
        swap(A[i], A[j]);  
        DirectedPermutations(i + 1, A_ptr, result);  
        swap(A[i], A[j]);  
    }
}

    vector<vector<int>> permute(vector<int> nums) {
        vector<vector<int>> result;
        DirectedPermutations(0, &nums, &result);
        return result;
    }
};