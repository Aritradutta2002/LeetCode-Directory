class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int[] arr = new int[2 * n];
        int currentFunctionValue = 0;
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            currentFunctionValue += (i * nums[i]);
            totalSum += nums[i];
        }

        int maxValue = currentFunctionValue;
        for (int j = 0; j < n; j++) {
            currentFunctionValue = currentFunctionValue + totalSum - (n * nums[n - j - 1]);
            maxValue = Math.max(maxValue, currentFunctionValue);
        }
        return maxValue;
    }
}