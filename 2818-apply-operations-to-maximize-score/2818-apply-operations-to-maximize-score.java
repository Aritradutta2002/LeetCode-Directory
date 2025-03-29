import java.util.*;

class Solution {

    private static final int MOD = 1_000_000_007;

    public int maximumScore(List<Integer> nums, int k) {
        int n = nums.size();
        int[] primeScores = new int[n];

        int maxElement = Collections.max(nums);
        List<Integer> primes = getPrimes(maxElement);

        for (int index = 0; index < n; index++) {
            int num = nums.get(index);
            for (int prime : primes) {
                if (prime * prime > num) break;
                if (num % prime != 0) continue;
                primeScores[index]++;
                while (num % prime == 0) num /= prime;
            }
            if (num > 1) primeScores[index]++;
        }

        int[] nextDominant = new int[n];
        int[] prevDominant = new int[n];
        Arrays.fill(nextDominant, n);
        Arrays.fill(prevDominant, -1);

        Stack<Integer> stack = new Stack<>();
        for (int index = 0; index < n; index++) {
            while (!stack.isEmpty() && primeScores[stack.peek()] < primeScores[index]) {
                int topIndex = stack.pop();
                nextDominant[topIndex] = index;
            }
            if (!stack.isEmpty()) prevDominant[index] = stack.peek();
            stack.push(index);
        }

        long[] numOfSubarrays = new long[n];
        for (int index = 0; index < n; index++) {
            numOfSubarrays[index] = (long) (nextDominant[index] - index) * (index - prevDominant[index]);
        }

        List<int[]> sortedArray = new ArrayList<>();
        for (int index = 0; index < n; index++) {
            sortedArray.add(new int[]{nums.get(index), index});
        }
        sortedArray.sort((a, b) -> Integer.compare(b[0], a[0]));

        long score = 1;
        int processingIndex = 0;

        while (k > 0) {
            int[] element = sortedArray.get(processingIndex++);
            int num = element[0];
            int index = element[1];

            long operations = Math.min(k, numOfSubarrays[index]);
            score = (score * power(num, operations)) % MOD;
            k -= operations;
        }

        return (int) score;
    }

    private long power(long base, long exponent) {
        long res = 1;
        while (exponent > 0) {
            if (exponent % 2 == 1) res = (res * base) % MOD;
            base = (base * base) % MOD;
            exponent /= 2;
        }
        return res;
    }

    private List<Integer> getPrimes(int limit) {
        boolean[] isPrime = new boolean[limit + 1];
        Arrays.fill(isPrime, true);
        List<Integer> primes = new ArrayList<>();

        for (int number = 2; number <= limit; number++) {
            if (!isPrime[number]) continue;
            primes.add(number);
            for (long multiple = (long) number * number; multiple <= limit; multiple += number) {
                isPrime[(int) multiple] = false;
            }
        }
        return primes;
    }
}
