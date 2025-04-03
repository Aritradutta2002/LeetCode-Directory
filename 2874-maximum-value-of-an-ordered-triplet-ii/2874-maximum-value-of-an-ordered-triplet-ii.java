class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        
        long maxTriplet = 0;
        
        int[] maxRight = new int[n];
        maxRight[n - 1] = 0; 
        for (int j = n - 2; j >= 0; j--) {
            maxRight[j] = Math.max(maxRight[j + 1], nums[j + 1]);
        }
        
        int maxI = nums[0];
        for (int j = 1; j < n - 1; j++) {
            long currentDiff = maxI - nums[j];
            long currentProduct = currentDiff * maxRight[j];
            if (currentProduct > maxTriplet) {
                maxTriplet = currentProduct;
            }
           
            if (nums[j] > maxI) {
                maxI = nums[j];
            }
        }
        
        return maxTriplet;
    }
}