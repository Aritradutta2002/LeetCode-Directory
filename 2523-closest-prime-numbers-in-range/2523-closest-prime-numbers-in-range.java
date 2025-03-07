class Solution {
 public static int[] closestPrimes(int left, int right) {
    int[] res = {-1, -1};
    int minDiff = Integer.MAX_VALUE;
    int prevPrime = -1;

    boolean[] isPrime = sieveOfEratosthenes(right);

    for (int i = left; i <= right; i++) {
        if (isPrime[i]) {
            if (prevPrime != -1) {
                int currDiff = i - prevPrime;
                if (currDiff < minDiff) {
                    minDiff = currDiff;
                    res[0] = prevPrime;
                    res[1] = i;
                }
            }
            prevPrime = i;
        }
    }
    return res;
}


private static boolean[] sieveOfEratosthenes(int n) {
    boolean[] isPrime = new boolean[n + 1];
    Arrays.fill(isPrime, true);
    isPrime[0] = isPrime[1] = false; 

    for (int i = 2; i * i <= n; i++) {
        if (isPrime[i]) {
            for (int j = i * i; j <= n; j += i) {
                isPrime[j] = false;
            }
        }
    }
    return isPrime;
    }
}