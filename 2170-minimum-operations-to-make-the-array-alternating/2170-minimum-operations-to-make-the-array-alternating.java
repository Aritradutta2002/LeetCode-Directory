class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> oddCount = new HashMap<>();
        HashMap<Integer, Integer> evenCount = new HashMap<>();
        int evenMaxVal = 0;
        int evenMaxCount = 0;
        int oddMaxVal = 0;
        int oddMaxCount = 0;
        int evenSecondMax = 0;
        int oddSecondMax = 0;

        int totalEvenIndex = (n + 1) / 2;
        int totalOddIndex = n / 2;

        for (int i = 0; i < n; i++) {
            if ((i & 1) == 0) {
                evenCount.put(nums[i], evenCount.getOrDefault(nums[i], 0) + 1);
            } else {
                oddCount.put(nums[i], oddCount.getOrDefault(nums[i], 0) + 1);
            }
        }

        // for even map highest & second highest finding
        for (int even : evenCount.keySet()) {
            int count = evenCount.get(even);
            if (count > evenMaxCount) {
                evenSecondMax = evenMaxCount;
                evenMaxCount = count;
                evenMaxVal = even;
            } else if (count > evenSecondMax) {
                evenSecondMax = count;
            }
        }

        // for even odd highest & second highest finding
        for (int odd : oddCount.keySet()) {
            int count = oddCount.get(odd);
            if (count > oddMaxCount) {
                oddSecondMax = oddMaxCount;
                oddMaxCount = count;
                oddMaxVal = odd;
            } else if (count > oddSecondMax) {
                oddSecondMax = count;
            }
        }

        if (evenMaxVal != oddMaxVal) {
            return (totalEvenIndex - evenMaxCount) + (totalOddIndex - oddMaxCount);
        } else {
            return Math.min(
                    (totalEvenIndex - evenMaxCount) + (totalOddIndex - oddSecondMax),
                    (totalEvenIndex - evenSecondMax) + (totalOddIndex - oddMaxCount));
        }
    }
}