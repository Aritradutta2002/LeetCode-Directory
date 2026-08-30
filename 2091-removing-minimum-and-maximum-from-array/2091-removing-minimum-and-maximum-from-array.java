class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int min = nums[0];
        int max = nums[0];
        int minIdx = -1;
        int maxIdx = -1;

        for (int i = 0; i < n; i++) {
            if (nums[i] >= max) {
                max = nums[i];
                maxIdx = i;
            }

            if (nums[i] <= min) {
                min = nums[i];
                minIdx = i;
            }
        }

        // total possible ways i) both front side ii) both back side iii) min from front + max from back iv) max from front and min from back 

        int firstOption = Math.max(minIdx + 1, maxIdx + 1);
        int secondOption = n - Math.min(minIdx, maxIdx);
        int thirdOption = (minIdx + 1) + (n - maxIdx);
        int fourthOption = (maxIdx + 1) + (n - minIdx);

        return Math.min(Math.min(firstOption, secondOption), Math.min(thirdOption, fourthOption));
    }
}