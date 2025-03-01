class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int sum=0,maxSum=0,minSum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum>maxSum) maxSum=sum;
            if(sum<minSum) minSum=sum;
        }
        return Math.abs(maxSum-minSum);
    }
}