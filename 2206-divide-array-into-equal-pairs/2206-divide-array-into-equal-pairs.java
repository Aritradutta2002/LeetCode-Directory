class Solution {
    public boolean divideArray(int[] nums) {
        long[] arr = new long[1501];
        arr[0] = 0;
        for(int i = 0; i < nums.length; i++){
            arr[nums[i]]++;
        }

        for(int i = 0; i < arr.length; i++){
            if(arr[i] % 2 != 0){
                return false;
            }
        }

        return true;
    }
}