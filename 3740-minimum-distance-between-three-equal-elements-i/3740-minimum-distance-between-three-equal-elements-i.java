class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            indexMap.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        int minDistance = Integer.MAX_VALUE;

        for (List<Integer> indices : indexMap.values()) {
            if (indices.size() < 3)
                continue;
            for (int t = 0; t + 2 < indices.size(); t++) {
                int dist = 2 * (indices.get(t + 2) - indices.get(t));
                minDistance = Math.min(minDistance, dist);
            }
        }

        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }
}