import java.util.*;

class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> obstacleSet = new HashSet<>();
        for (int[] obs : obstacles) {
            obstacleSet.add(obs[0] + "," + obs[1]);
        }

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int x = 0, y = 0;
        int dirIndex = 0;
        int maxDistSq = 0;

        for (int cmd : commands) {
            if (cmd == -1) {
                dirIndex = (dirIndex + 1) % 4;
            } else if (cmd == -2) {
                dirIndex = (dirIndex + 3) % 4;
            } else {
                for (int i = 0; i < cmd; i++) {
                    int nextX = x + directions[dirIndex][0];
                    int nextY = y + directions[dirIndex][1];

                    if (obstacleSet.contains(nextX + "," + nextY)) {
                        break;
                    }

                    x = nextX;
                    y = nextY;
                    maxDistSq = Math.max(maxDistSq, x * x + y * y);
                }
            }
        }

        return maxDistSq;
    }
}