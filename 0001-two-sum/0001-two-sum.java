class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int remaining = target - nums[i];
            if(map.containsKey(remaining)){
                int x = i;
                int y = map.get(remaining);
                return new int [] {x, y};
            }
            map.put(nums[i], i);
        }

        return new int[] {-1, -1};
    }
}