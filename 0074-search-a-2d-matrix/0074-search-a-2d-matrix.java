class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;

        int low = 0;
        int high = row * col - 1;

        while(low <= high){
            int mid = low + (high - low)/2;
            int midValue = matrix[mid/col][mid % col];
            if(midValue == target) return true;
            else if(midValue > target) high = mid - 1;
            else low = mid + 1;
        }

        return false;
    }
}