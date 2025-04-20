import java.util.Arrays;

class Solution {
    public static long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        int N = nums.length;
        long ans = 0;
        for (int i = 0; i < N - 1; i++) {
            int lb = lowerBound(nums, i + 1, N, lower - nums[i]);
            int ub = upperBound(nums, i + 1, N, upper - nums[i]);
            ans += (ub - lb);
        }
        return ans;
    }
    
    public static int lowerBound(int[] nums, int start, int N, int target) {
        int low = start, high = N - 1;
        int ans = N;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    
    public static int upperBound(int[] nums, int start, int N, int target) {
        int low = start, high = N - 1;
        int ans = N;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}