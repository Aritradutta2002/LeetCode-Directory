import java.util.*;

class Solution {
    public int maxSum(int[] nums) {
        int max = Arrays.stream(nums).max().orElse(Integer.MIN_VALUE);
        if (max <= 0) return max;

        int sum = 0;
        Set<Integer> seen = new HashSet<>();
        for (int n : nums) if (n >= 0 && seen.add(n)) sum += n;
        return sum;
    }
}
