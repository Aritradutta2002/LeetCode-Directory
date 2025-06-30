class Solution {
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        int maxLength = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            if(map.containsKey(key + 1)) {
                maxLength = Math.max(maxLength, entry.getValue() + map.get(key + 1));
            }
        }

        return maxLength;
    }
}