class Solution {
    public int repeatedNTimes(int[] nums) {
        //  length  == 2 * n (where n = repeated element)

        int len = nums.length;
        int n = (len / 2);
        int pointer = nums[0];
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            if (pointer != nums[i]) {
                pointer = nums[i];
                count = 0;
            }
            count++;
            if(count == n){
                return pointer;
            }
        }
        return -1;
    }
}