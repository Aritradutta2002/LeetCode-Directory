import java.util.*;

class Solution {
    public int maxFrequencyScore(int[] nums, long k) {
        Arrays.sort(nums);
        int n = nums.length, left = 0, right = n;
        long[] prefix = new long[n + 1];
        
        for (int i = 1; i <= n; i++) prefix[i] = prefix[i - 1] + nums[i - 1];
        
        while (left < right) {
            int mid = (left + right + 1) >> 1;
            boolean possible = false;
            
            for (int i = 0; i <= n - mid; i++) {
                int j = i + mid, target = nums[(i + j) / 2];
                long cost = ((i + j) / 2 - i) * (long) target - (prefix[(i + j) / 2] - prefix[i])
                          + (prefix[j] - prefix[(i + j) / 2]) - ((j - (i + j) / 2) * (long) target);
                if (cost <= k) {
                    possible = true;
                    break;
                }
            }
            if (possible) left = mid;
            else right = mid - 1;
        }
        return left;
    }
}