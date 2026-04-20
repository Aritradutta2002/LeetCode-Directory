class Solution {
    public int maxDistance(int[] colors) {
        Map<Integer, Integer> first = new HashMap<>();
        Map<Integer, Integer> last = new HashMap<>();

        for (int i = 0; i < colors.length; i++) {
            int color = colors[i];
            if (!first.containsKey(color)) {
                first.put(color, i);
            }
            last.put(color, i);
        }

        int maxDist = 0;
        for (int color1 : first.keySet()) {
            for (int color2 : last.keySet()) {
                if (color1 != color2) {
                    maxDist = Math.max(maxDist, Math.abs(last.get(color2) - first.get(color1)));
                }
            }
        }

        return maxDist;
    }
}