class Solution {
    public boolean isPowerOfFour(int n) {
        // A power of four must be a positive number.
        if (n <= 0) {
            return false;
        }

        // Repeatedly divide by 4.
        while (n % 4 == 0) {
            n /= 4;
        }

        // If the number is a power of four, we should be left with 1.
        return n == 1;
    }
}