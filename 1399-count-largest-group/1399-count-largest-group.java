class Solution {
    public int countLargestGroup(int n) {
        int[] sumCount = new int[37];
        for (int i = 1; i <= n; i++) {
            int sum = digitSum(i);
            sumCount[sum]++;
        }
        int maxSize = 0;
        for (int count : sumCount) {
            if (count > maxSize) {
                maxSize = count;
            }
        }
        int numberOfLargestGroups = 0;
        for (int count : sumCount) {
            if (count == maxSize) {
                numberOfLargestGroups++;
            }
        }
        return numberOfLargestGroups;
    }
    private int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += (num % 10);
            num /= 10;
        }
        return sum;
    }
}
