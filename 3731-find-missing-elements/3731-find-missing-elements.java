class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int n = nums.length;
        List<Integer> missingElements = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < n - 1; i++) {
            int current = nums[i];
            int next = nums[i + 1];
            for (int j = current + 1; j < next; j++) {
                missingElements.add(j);
            }
        }

        return missingElements;
    }
}