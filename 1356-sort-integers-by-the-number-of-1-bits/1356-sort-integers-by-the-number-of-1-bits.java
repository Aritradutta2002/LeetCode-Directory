class Solution {
    public int[] sortByBits(int[] arr) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();

        for (int num : arr) {
            int bits = Integer.bitCount(num);
            map.computeIfAbsent(bits, k -> new ArrayList<>()).add(num);
        }

        int idx = 0;
        int[] result = new int[arr.length];
        for (List<Integer> group : map.values()) {   
            Collections.sort(group);                  
            for (int num : group) result[idx++] = num;
        }
        return result;
    }
}