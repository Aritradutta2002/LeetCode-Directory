class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] && (i == 1 || nums[i] != nums[i - 2])){
                list.add(nums[i]);
            }
        }

        return list;
    }
}