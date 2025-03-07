class Solution {
    private static final int MX = 1000000;
    private static List<Integer> primes = new ArrayList<>();

    static {
        boolean[] isPrime = new boolean[MX + 1];
        Arrays.fill(isPrime, true);
        for (int i = 2; i <= MX; i++) {
            if (!isPrime[i]) continue;
            primes.add(i);
            for (int j = i; j <= MX / i; j++) {
                isPrime[j * i] = false;
            }
        }
    }

    public int[] closestPrimes(int left, int right) {
        int beg = lowerBound(left);
        int end = lowerBound(right + 1) - 1;
        if (end - beg < 1) return new int[]{-1, -1};
        int min = Integer.MAX_VALUE;
        int[] ans = new int[2];
        while (end > beg) {
            int d = primes.get(end) - primes.get(end - 1);
            if (d <= min) {
                min = d;
                ans[0] = primes.get(end - 1);
                ans[1] = primes.get(end);
            }
            end--;
        }
        return ans;
    }

    private int lowerBound(int target) {
        int beg = -1, end = primes.size();
        while (end - beg > 1) {
            int mid = beg + (end - beg) / 2;
            if (primes.get(mid) >= target) {
                end = mid;
            } else {
                beg = mid;
            }
        }
        return end;
    }
}