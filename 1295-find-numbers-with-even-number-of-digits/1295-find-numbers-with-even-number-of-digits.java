class Solution {
   public static int findNumbers(int[] nums) {
        int count = 0;
        for(int i : nums){
            int len = (int) Math.log10(i) + 1;
            if(len % 2 == 0){
                count++;
            }
        }
        return count;
    }
}