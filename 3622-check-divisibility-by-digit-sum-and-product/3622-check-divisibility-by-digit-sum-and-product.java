class Solution {
    public boolean checkDivisibility(int n) {
        int copy = n;
        int sum = 0;
        int multiplication = 1;
        while (copy > 0) {
            sum += copy % 10;
            multiplication *= copy % 10;
            copy /= 10;
        }
        return (n % (sum + multiplication) == 0);
    }
}