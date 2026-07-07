class Solution {
    public long sumAndMultiply(int n) {
        long x = 0;
        int sum = 0;

        for (char digitChar : String.valueOf(n).toCharArray()) {
            int digit = digitChar - '0';
            if (digit == 0) {
                continue;
            }

            x = x * 10 + digit;
            sum += digit;
        }

        return x * sum;
    }
}