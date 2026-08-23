class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        int[][] events = new int[buildings.length * 2][];
        int idx = 0;
        for (int[] b : buildings) {
            events[idx++] = new int[] { b[0], -b[2] };
            events[idx++] = new int[] { b[1], b[2] };
        }

        Arrays.sort(events, (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));

        TreeMap<Integer, Integer> active = new TreeMap<>();
        active.put(0, 1);
        List<List<Integer>> result = new ArrayList<>();
        int prevHeight = 0;
        for (int[] e : events) {
            int x = e[0], h = e[1];
            if (h < 0) {
                active.merge(-h, 1, Integer::sum);
            } else {
                int count = active.get(h);
                if (count == 1) {
                    active.remove(h);
                } else {
                    active.put(h, count - 1);
                }
            }
            int height = active.lastKey();
            if (height != prevHeight) {
                result.add(List.of(x, height));
                prevHeight = height;
            }
        }
        return result;
    }
}