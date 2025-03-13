class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] differenceArray = new int[n + 1];
        int sum = 0;
        int k = 0;

        for (int index = 0; index < n; index++) {
            while (sum + differenceArray[index] < nums[index]) {
                k++;

                if (k > queries.length) {
                    return -1;
                }

                int left = queries[k - 1][0];
                int right = queries[k - 1][1];
                int val = queries[k - 1][2];

                if (right >= index) {
                    differenceArray[Math.max(left, index)] += val;
                    differenceArray[right + 1] -= val;
                }
            }

            sum += differenceArray[index];
        }

        return k;
    }
}