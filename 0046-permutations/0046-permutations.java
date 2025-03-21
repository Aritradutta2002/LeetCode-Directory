class Solution {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>(); // to store returning the result
        List<Integer> permutation = new ArrayList<>(); // to store one of the permutation after each recursive call
        Set<Integer> visited = new HashSet<>(); // to track if the element is already added to the permutation list
        helper(nums, permutation, res, visited, 0); // permuteBackTrack helper function
        return res;
    }

    public static void helper(int[] nums, List<Integer> permutation, List<List<Integer>> res, Set<Integer> visited, int currentIndex) {
        if (visited.size() == nums.length) {
            res.add(new ArrayList<>(permutation));
            return;
        }
        for (int i = currentIndex; i < nums.length; i++) {
            if(!visited.contains(nums[i])) {
                permutation.add(nums[i]);
                visited.add(nums[i]);
                helper(nums, permutation, res, visited, currentIndex);
                permutation.removeLast();
                visited.remove(nums[i]);
            }
        }
    }
}