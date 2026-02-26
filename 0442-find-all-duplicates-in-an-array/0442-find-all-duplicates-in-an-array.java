class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        for (int num : nums) {
            if (!seen.add(num)) {
                ans.add(num);
            }
        }
        return ans;
    }
}