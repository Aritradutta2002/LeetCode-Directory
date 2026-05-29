class Solution {
    public int minElement(int[] nums) {
        int n = nums.length;
        int minimum = Integer.MAX_VALUE;
        for (int i : nums) {
            minimum = Math.min(minimum, digitSum(i));
        }
        return minimum;
    }

    public int digitSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}