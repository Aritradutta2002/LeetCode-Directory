class Solution {
    public int gcdOfOddEvenSums(int n) {
        int oddSum = 0;
        int evenSum = 0;
        int oddCount = 0;
        int evenCount = 0;

        for (int i = 1; i <= 2000; i++) {
            if (i % 2 == 0) {
                evenSum += i;
                evenCount++;
            }
            if (evenCount == n)
                break;
        }

        for (int i = 1; i <= 2000; i++) {
            if (i % 2 != 0) {
                oddSum += i;
                oddCount++;
            }
            if (oddCount == n)
                break;
        }

        return gcd(oddCount, evenCount);
    }

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}