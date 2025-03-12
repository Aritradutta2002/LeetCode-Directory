class Solution {
    public int maximumCount(int[] nums) {
        int max = 0;
        int neg = 0;
        int pos = 0;

        for(int x : nums){
            if(x < 0){
                neg ++;
            }

            if(x > 0){
                pos++;
            }
        }

        return Math.max(neg, pos);
    }
}