class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        return binarySearch(workerTimes, mountainHeight);
    }

    public long binarySearch(int[] workerTimes, int mountainHeight) {
        long low = 0;
        long high = (long) 1e18;

        while (low < high) {
            long mid = (low + high) / 2;
            if (canFinish(mid, mountainHeight, workerTimes)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public boolean canFinish(long T, int mountainHeight, int[] workerTimes) {
        long totalReduce = 0;

        for (int w : workerTimes) {
            long x = (long) ((-1 + Math.sqrt(1 + 8.0 * T / w)) / 2);
            totalReduce += x;
            if (totalReduce >= mountainHeight)
                return true;
        }
        return totalReduce >= mountainHeight;
    }
}