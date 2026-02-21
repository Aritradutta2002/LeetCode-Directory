class Solution {
    public static int countPrimeSetBits(int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            int setBit = Integer.bitCount(i);
            if (isPrime(setBit)) {
                count++;
            }
        }

        return count;
    }

    public static boolean isPrime(int n) {
        if (n < 2)
            return false;
        if (n == 2)
            return true;
        if (n % 2 == 0)
            return false; 
        for (int i = 3; i * i <= n; i += 2) { 
            if (n % i == 0)
                return false;
        }
        return true;
    }
}