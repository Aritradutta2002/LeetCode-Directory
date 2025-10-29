class Solution {
    public List<Integer> grayCode(int n) {
        if (n == 1) {
            return java.util.Arrays.asList(0, 1);
        }
        
        java.util.List<Integer> prevGray = grayCode(n - 1);
        java.util.List<Integer> result = new java.util.ArrayList<>(prevGray);
        
        // Add reversed previous sequence with MSB set
        int msb = 1 << (n - 1);
        for (int i = prevGray.size() - 1; i >= 0; i--) {
            result.add(prevGray.get(i) | msb);
        }
        
        return result;
    }
}