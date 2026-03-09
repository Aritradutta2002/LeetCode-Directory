class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] maxDp = new int[n];
        int[] minDp = new int[n];

        maxDp[0] = nums[0];
        minDp[0] = nums[0];
        int maxProduct = nums[0];

        for (int i = 1; i < n; i++) {
            int current = nums[i];

            maxDp[i] = Math.max(current,
                    Math.max(current * maxDp[i - 1], current * minDp[i - 1]));

            minDp[i] = Math.min(current,
                    Math.min(current * maxDp[i - 1], current * minDp[i - 1]));

            maxProduct = Math.max(maxProduct, maxDp[i]);
        }

        return maxProduct;
    }
}