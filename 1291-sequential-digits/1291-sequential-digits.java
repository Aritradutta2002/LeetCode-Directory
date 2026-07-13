class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();

        for (int startDigit = 1; startDigit <= 9; startDigit++) {
            long num = startDigit;
            int nextDigit = startDigit + 1;
            while (nextDigit <= 9) {
                num = num * 10 + nextDigit;
                if (num > high) {
                    break;
                }
                if (num >= low) {
                    result.add((int) num);
                }
                nextDigit++;
            }
        }

        Collections.sort(result);
        return result;
    }
}