class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = numbers.length;
        int start = -1;
        int end = -1;
        for (int i = 0; i < n; i++) {
            int remaining = target - numbers[i];
            if (map.containsKey(numbers[i])) {
                start = map.get(numbers[i]) + 1;
                end = i + 1;
                return new int[] { start, end };
            }
            map.put(remaining, i);
        }
        return new int[] { start, end };
    }
}