class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
       int n = nums.length;
       
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums[i];
            pairs[i][1] = i;
        }
        
        Arrays.sort(pairs, (a, b) -> Integer.compare(b[0], a[0]));
      
        int[] indices = new int[k];
        for (int i = 0; i < k; i++) {
            indices[i] = pairs[i][1];
        }
        
        Arrays.sort(indices);
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = nums[indices[i]];
        }
        return result;
    }
}