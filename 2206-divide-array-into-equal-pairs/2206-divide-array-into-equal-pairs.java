class Solution {
    public boolean divideArray(int[] nums) {
        long[] arr = new long[1501];
        arr[0] = 0;
        
        for(var ele : nums){
            arr[ele]++;
        }

        for(var ele : arr){
            if(ele % 2 != 0){
                return false;
            }
        }

        return true;
    }
}