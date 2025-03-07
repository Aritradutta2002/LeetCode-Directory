class Solution {
    public static int[] closestPrimes(int left, int right) {
        int[] res = {-1, -1};
        int minDiff = Integer.MAX_VALUE;
        int prevPrime = -1;

        // Generate all primes up to sqrt(right) using Sieve of Eratosthenes
        int sqrtRight = (int) Math.sqrt(right);
        boolean[] isPrime = sieveOfEratosthenes(sqrtRight);

        // Segmented sieve to find primes in [left, right]
        boolean[] rangePrimes = new boolean[right - left + 1];
        Arrays.fill(rangePrimes, true);

        // Handle the case where left is less than 2
        if (left < 2) {
            for (int i = left; i < 2; i++) {
                rangePrimes[(int) (i - left)] = false;
            }
        }

        for (int p = 2; p <= sqrtRight; p++) {
            if (isPrime[p]) {
                // Mark multiples of p in [left, right] as non-prime
                int start = Math.max(p * p, left + ((p - left % p) % p));
                for (int j = start; j <= right; j += p) {
                    rangePrimes[(int) (j - left)] = false;
                }
            }
        }

        // Iterate through [left, right] to find the closest primes
        for (int i = left; i <= right; i++) {
            if (i >= 2 && rangePrimes[(int) (i - left)]) {
                if (prevPrime != -1) {
                    int currDiff = i - prevPrime;
                    if (currDiff < minDiff) {
                        minDiff = currDiff;
                        res[0] = prevPrime;
                        res[1] = i;
                        if (minDiff == 1) {
                            break; // Early exit if the smallest possible difference is found
                        }
                    }
                }
                prevPrime = i;
            }
        }
        return res;
    }

    // Helper function: Sieve of Eratosthenes to precompute primes up to n
    private static boolean[] sieveOfEratosthenes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false; // 0 and 1 are not primes

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