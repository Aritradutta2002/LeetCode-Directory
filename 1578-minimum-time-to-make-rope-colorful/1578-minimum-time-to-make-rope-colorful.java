  class Solution {
        public static int minCost(String colors, int[] neededTime) {
            if (colors == null || neededTime == null || colors.length() != neededTime.length) {
                throw new IllegalArgumentException("Invalid input");
            }

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
    }