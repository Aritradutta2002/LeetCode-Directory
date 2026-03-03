class Solution {
    public int climbStairs(int n) {
        if(n == 1 || n == 2) return n;

        int first = 1;
        int second = 2;
        int curr = 0;


        for(int i = 3; i <= n; i++){
            curr = first + second;
            first = second;
            second = curr;
        }

        return curr;
    }
}