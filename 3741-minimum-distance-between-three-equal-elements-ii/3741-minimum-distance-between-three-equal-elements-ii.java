class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> positions = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            positions.computeIfAbsent(nums[i], key -> new ArrayList<>()).add(i);
        }

        int minDistance = Integer.MAX_VALUE;

        for (List<Integer> list : positions.values()) {
            for (int i = 2; i < list.size(); i++) {
                int first = list.get(i - 2);
                int third = list.get(i);
                minDistance = Math.min(minDistance, 2 * (third - first));
            }
        }

        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }
}