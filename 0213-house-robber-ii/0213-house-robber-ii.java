class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        java.util.function.BiFunction<Integer, Integer, Integer> robLinear =
                (l, r) -> {
                    int prev2 = 0; 
                    int prev1 = 0; 
                    for (int i = l; i <= r; i++) {
                        int cur = Math.max(prev1, prev2 + nums[i]);
                        prev2 = prev1;
                        prev1 = cur;
                    }
                    return prev1; 
                };

        int excludeLast = robLinear.apply(0, n - 2); 
        int excludeFirst = robLinear.apply(1, n - 1); 
        return Math.max(excludeLast, excludeFirst);
    }
}