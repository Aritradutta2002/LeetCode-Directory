class Solution {
    public int minimumDistance(int[] nums) {
        int maxVal = 0;
        for (int num : nums) {
            if (num > maxVal)
                maxVal = num;
        }

        int[] last = new int[maxVal + 1];
        int[] secondLast = new int[maxVal + 1];
        Arrays.fill(last, -1);
        Arrays.fill(secondLast, -1);

        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (secondLast[x] != -1) {
                int dist = 2 * (i - secondLast[x]);
                minDistance = Math.min(minDistance, dist);
            }
            secondLast[x] = last[x];
            last[x] = i;
        }

        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }
}