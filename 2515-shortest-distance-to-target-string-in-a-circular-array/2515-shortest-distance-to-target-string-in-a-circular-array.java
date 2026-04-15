class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int minDistance = Integer.MAX_VALUE;
        boolean found = false;

        for (int i = 0; i < n; i++) {
            if (words[i].equals(target)) {
                found = true;
                int dist = Math.abs(i - startIndex);
                minDistance = Math.min(minDistance, Math.min(dist, n - dist));
            }
        }

        return found ? minDistance : -1;
    }
}