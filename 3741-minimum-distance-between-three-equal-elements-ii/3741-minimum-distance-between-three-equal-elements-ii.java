class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        int[] first = new int[n + 1];
        int[] second = new int[n + 1];
        int[] count = new int[n + 1];
        Arrays.fill(first, -1);
        Arrays.fill(second, -1);
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int value = nums[i];

            if (count[value] >= 2) {
                minDistance = Math.min(minDistance, 2 * (i - first[value]));
            }

            if (count[value] == 0) {
                first[value] = i;
            } else if (count[value] == 1) {
                second[value] = i;
            } else {
                first[value] = second[value];
                second[value] = i;
            }

            count[value]++;
        }

        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }
}