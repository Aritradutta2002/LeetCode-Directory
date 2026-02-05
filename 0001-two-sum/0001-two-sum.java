class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[][] pairs = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            pairs[i][0] = nums[i];
            pairs[i][1] = i;
        }

        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));
        
        int l = 0, r = nums.length - 1;
        
        while (l < r) {
            int sum = pairs[l][0] + pairs[r][0];
            
            if (sum == target) {
                return new int[]{pairs[l][1], pairs[r][1]};
            } else if (sum < target) {
                l++;
            } else {
                r--;
            }
        }
        
        return new int[]{-1, -1};
    }
}