class Solution {
    public int smallestNumber(int n) {
    int mask = (1 << (32 - Integer.numberOfLeadingZeros(n))) - 1;
       return mask;
    }
}