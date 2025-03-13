class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
         int n = nums.length;
    int[] diff = new int[n + 1];
    diff[0] = nums[0];
    for (int i = 1; i < n; i++) {
        diff[i] = nums[i] - nums[i - 1];
    }

    long total = 0;
    for (int x : nums) {
        total += x;
    }
    if (total == 0) {
        return 0;
    }

    for (int k = 0; k < queries.length; k++) {
        int l = queries[k][0];
        int r = queries[k][1];
        int val = queries[k][2];

        diff[l] -= val;
        if (r + 1 < n) {
            diff[r + 1] += val;
        }

        if (l == 0) {
            total -= val * (r - l + 1);
        } else {
            total -= val * (r - l + 1);
        }

        if (total <= 0) {
            boolean isZeroArray = true;
            int current = 0;
            for (int i = 0; i < n; i++) {
                current += diff[i];
                if (current != 0) {
                    isZeroArray = false;
                    break;
                }
            }
            if (isZeroArray) {
                return k + 1;
            }
        }
    }

    return -1;
    }
}