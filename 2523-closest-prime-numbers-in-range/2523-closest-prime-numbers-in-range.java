class Solution {
    public static int[] closestPrimes(int left, int right) {
        int[] res = {-1, -1};
        int minDiff = Integer.MAX_VALUE;
        int prevPrime = -1;

        for (int i = left; i <= right; i++) {
            if (isPrime(i)) {
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
    
    public static boolean isPrime(long n) {
        if(n < 2) return false;
        if(n == 2 || n == 3) return true;
        if(n%2 == 0 || n%3 == 0) return false;
        long sqrtN = (long)Math.sqrt(n)+1;
        for(long i = 6L; i <= sqrtN; i += 6) {
            if(n%(i-1) == 0 || n%(i+1) == 0) return false;
        }
        return true;
    }
}