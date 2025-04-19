class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        
        int n = nums.length;
        long count = 0;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                int sum = nums[i] + nums[j];
                if(sum >= lower && sum <= upper){
                    count++;
                }
            }
        }
        return count;
    }
}