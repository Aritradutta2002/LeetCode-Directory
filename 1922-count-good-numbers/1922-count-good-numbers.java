class Solution {
    static final long MOD = 1000000007;
    public static int countGoodNumbers(long n) {
        long evenExponent = (n + 1) / 2; 
        long oddExponent = n / 2;         
        
        long goodCount = (modPow(5, evenExponent) * modPow(4, oddExponent)) % MOD;
        return (int) goodCount;
    }
    
    public static long modPow(long base, long exponent) {
        long result = 1;
        base %= MOD;
        while(exponent > 0) {
            if((exponent & 1) == 1) {
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            exponent >>= 1;
        }
        return result;
    }
}