class Solution {
    public int subsetXORSum(int[] nums) {
        int n = nums.length;
        return solveBacktrack(nums, 0, 0);
    }

    private int solveBacktrack(int[] nums, int index, int sum) {
        if (index >= nums.length) {
            return sum;
        }

        int pickingElementXor = solveBacktrack(nums, index + 1, sum ^ nums[index]);
        int NotpickingElementXor = solveBacktrack(nums, index + 1, sum);

        return (pickingElementXor + NotpickingElementXor);
    }
}