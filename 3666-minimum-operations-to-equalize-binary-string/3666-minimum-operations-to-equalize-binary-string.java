class Solution {
    public int minOperations(String s, int k) {
        int n = s.length();
        int initialZeros = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                initialZeros++;
            }
        }

        if (initialZeros == 0)
            return 0;

        BitSet evenUnvisited = new BitSet(n + 1);
        BitSet oddUnvisited = new BitSet(n + 1);

        for (int i = 0; i <= n; i++) {
            if (i == initialZeros)
                continue;
            if (i % 2 == 0)
                evenUnvisited.set(i);
            else
                oddUnvisited.set(i);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { initialZeros, 0 });

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int z = current[0];
            int dist = current[1];

  
            int zMin = z + k - 2 * Math.min(k, z);
            int zMax = z + k - 2 * Math.max(0, k - (n - z));

            int targetParity = (z + k) % 2;
            BitSet unvisited = (targetParity == 0) ? evenUnvisited : oddUnvisited;

            for (int nextZ = unvisited.nextSetBit(zMin); nextZ != -1
                    && nextZ <= zMax; nextZ = unvisited.nextSetBit(nextZ)) {
                if (nextZ == 0)
                    return dist + 1;
                queue.offer(new int[] { nextZ, dist + 1 });
                unvisited.clear(nextZ);
            }
        }

        return -1;
    }
}