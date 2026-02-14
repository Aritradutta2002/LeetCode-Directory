class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int countZero = 0;
        int countOne = 0;
        int countTwo = 0;
        int j = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] == 0){
                countZero++;
            }
            if(nums[i] == 1){
                countOne++;
            }
            if(nums[i] == 2){
                countTwo++;
            }
        }

        while(countZero-->0){
            nums[j++] = 0;
        }

        while(countOne-->0){
            nums[j++] = 1;
        }

        while(countTwo-->0){
            nums[j++] = 2;
        }
    }
}