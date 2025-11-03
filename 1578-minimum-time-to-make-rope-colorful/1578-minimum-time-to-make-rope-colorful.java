class Solution {
    public static int minCost(String colors, int[] neededTime) {
        return minCostOptimized(colors, neededTime);
    }

    public static int minCostOptimized(String colors, int[] neededTime) {
        validateInput(colors, neededTime);

        int totalCost = 0;
        int maxTimeInGroup = 0;

        for (int i = 0; i < colors.length(); i++) {
            if (i > 0 && colors.charAt(i) != colors.charAt(i - 1)) {
                maxTimeInGroup = 0;
            }

            totalCost += Math.min(maxTimeInGroup, neededTime[i]);
            maxTimeInGroup = Math.max(maxTimeInGroup, neededTime[i]);
        }

        return totalCost;
    }

    public static int minCostGroupSort(String colors, int[] neededTime) {
        validateInput(colors, neededTime);

        int totalCost = 0;
        int i = 0;

        while (i < colors.length()) {
            char currentColor = colors.charAt(i);
            List<Integer> groupTimes = new ArrayList<>();

            while (i < colors.length() && colors.charAt(i) == currentColor) {
                groupTimes.add(neededTime[i]);
                i++;
            }

            if (groupTimes.size() > 1) {
                Collections.sort(groupTimes);
                for (int j = 0; j < groupTimes.size() - 1; j++) {
                    totalCost += groupTimes.get(j);
                }
            }
        }

        return totalCost;
    }

    public static int minCostNaiveSimulation(String colors, int[] neededTime) {
        validateInput(colors, neededTime);

        StringBuilder rope = new StringBuilder(colors);
        List<Integer> times = new ArrayList<>(neededTime.length);
        for (int time : neededTime) {
            times.add(time);
        }

        int totalCost = 0;
        int index = 0;

        while (index < rope.length() - 1) {
            if (rope.charAt(index) == rope.charAt(index + 1)) {
                int leftTime = times.get(index);
                int rightTime = times.get(index + 1);

                if (leftTime <= rightTime) {
                    totalCost += times.remove(index);
                    rope.deleteCharAt(index);
                    if (index > 0) {
                        index--;
                    }
                } else {
                    totalCost += times.remove(index + 1);
                    rope.deleteCharAt(index + 1);
                    if (index > 0) {
                        index--;
                    }
                }
            } else {
                index++;
            }
        }

        return totalCost;
    }

    private static void validateInput(String colors, int[] neededTime) {
        if (colors == null || neededTime == null || colors.length() != neededTime.length) {
            throw new IllegalArgumentException("Invalid input");
        }
    }
}