class Solution {
    public int rotatedDigits(int n) {
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isGood(i)) {
                count++;
            }
        }
        return count;
    }

    public boolean isGood(int n) {
        int curr = n;
        boolean isValid = false;
        while (n > 0) {
            int digit = n % 10;
            if (digit == 3 || digit == 4 || digit == 7) {
                return false;
            }
            if (digit == 2 || digit == 5 || digit == 6 || digit == 9) {
                isValid = true;
            }
            n /= 10;
        }
        return isValid;
    }
}