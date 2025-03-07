class Solution {
    public int[] closestPrimes(int left, int right) {
        int prev = -1;
        int[] res = {-1, -1};
        for (int i = left; i <= right; i++) {
            if (isPrime(i)) {
                if (prev != -1 && (res[0] == -1 || i - prev < res[1] - res[0])) {
                    res[0] = prev;
                    res[1] = i;
                    if (res[1] - res[0] <= 2) {
                        break;
                    }
                }
                
                prev = i;                
            }
            
            // System.out.printf("i=%d prev=%d res=%s\n", i, prev, Arrays.toString(res));
        }
        
        return res;
    }
    
    private boolean isPrime(int v) {
        if (v == 1) {
            return false;
        }
        
        for (int i = 2; i <= Math.sqrt(v); i++) {
            if (v % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}