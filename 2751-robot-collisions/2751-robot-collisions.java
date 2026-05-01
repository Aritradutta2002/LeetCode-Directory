class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (i, j) -> Integer.compare(positions[i], positions[j]));

        Stack<Integer> rightMovingRobots = new Stack<>();

        for (int robot : indices) {
            if (directions.charAt(robot) == 'R') {
                rightMovingRobots.push(robot);
            } else {
                while (!rightMovingRobots.isEmpty() && healths[robot] > 0) {
                    int opponent = rightMovingRobots.pop();

                    if (healths[opponent] > healths[robot]) {
                        healths[opponent]--;
                        healths[robot] = 0;
                        rightMovingRobots.push(opponent);
                    } else if (healths[opponent] < healths[robot]) {
                        healths[robot]--;
                        healths[opponent] = 0;
                    } else {
                        healths[robot] = 0;
                        healths[opponent] = 0;
                    }
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int health : healths) {
            if (health > 0) {
                result.add(health);
            }
        }
        return result;
    }
}