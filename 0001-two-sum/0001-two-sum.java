class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = target - nums[i];
            if (map.containsKey(num) == true) {
                return new int[] {map.get(num), i};
            }
            map.put(nums[i], i);
        }

        return new int[] { -1, -1 };
    }
}