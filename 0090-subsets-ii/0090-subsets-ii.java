class Solution {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        backtrackWithDup(nums, 0, new ArrayList<>(), ans);

        return ans;
    }

    public static void backtrackWithDup(int[] nums, int start, List<Integer> temp, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1])
                continue;
            temp.add(nums[i]);
            backtrackWithDup(nums, i + 1, temp, ans);
            temp.remove(temp.size() - 1);
        }
    }
}