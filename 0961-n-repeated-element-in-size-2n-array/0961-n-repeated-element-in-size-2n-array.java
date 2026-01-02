class Solution {
    public int repeatedNTimes(int[] nums) {
        //  length  == 2 * n (where n = repeated element)

        int len = nums.length;
        int n = (len / 2);

        Map<Integer, Integer> map = new HashMap<>();

        for (var element : nums) {
            map.put(element, map.getOrDefault(element, 0) + 1);
        }

        for (int k : map.keySet()) {
            if (map.get(k) > 1) {
                return k;
            }
        }

        return -1;
    }
}