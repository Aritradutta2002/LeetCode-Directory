class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for(int i : nums){
            if(isEven(i)){
                count++;
            }
        }
        return count;
    }

    boolean isEven(int num){
        boolean isEven = false;
        while(num > 0){
            int digit = num % 10;
            if(digit % 2 != 0){
                return false;
            }
            num /= 10;
        }
        return true;
    }
}