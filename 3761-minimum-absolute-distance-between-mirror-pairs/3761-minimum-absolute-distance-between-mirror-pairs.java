class Solution {
    public int minMirrorPairDistance(int[] nums) {
        int n = nums.length;
        int minimumDistance = n + 1;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                minimumDistance = Math.min(minimumDistance, i - map.get(nums[i]));
            }
            map.put(reverse(nums[i]), i);
        }

        return minimumDistance == n + 1 ? -1 : minimumDistance;
    }

    public int reverse(int n) {
        int x = 0;
        while (n > 0) {
            x = x * 10 + (n % 10);
            n /= 10;
        }
        return x;
    }
}