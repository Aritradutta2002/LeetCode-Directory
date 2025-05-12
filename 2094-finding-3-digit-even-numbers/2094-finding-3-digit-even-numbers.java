class Solution {
    public int[] findEvenNumbers(int[] digits) {
        List<Integer> evenNumbers = new ArrayList<>();

        int n = digits.length;
        if (n < 3) {
            return new int[0];
        }

        for (int i = 0; i < n; i++) {
            if (digits[i] == 0) {
                continue;
            }
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                for (int k = 0; k < n; k++) {
                    if (i == k || j == k) {
                        continue;
                    }
                    if (digits[k] % 2 != 0) {
                        continue;
                    }
                    int number = digits[i] * 100 + digits[j] * 10 + digits[k];
                    evenNumbers.add(number);
                }
            }
        }

        return evenNumbers.stream()
                .distinct()
                .sorted()
                .mapToInt(Integer::intValue)
                .toArray();

    }
}