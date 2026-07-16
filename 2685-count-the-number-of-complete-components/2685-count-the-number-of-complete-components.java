class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int completeComponents = 0;

        for (int node = 0; node < n; node++) {
            if (visited[node]) {
                continue;
            }

            int[] componentStats = new int[2];
            dfs(node, graph, visited, componentStats);
            int nodes = componentStats[0];
            int degreeSum = componentStats[1];
            if (degreeSum == nodes * (nodes - 1)) {
                completeComponents++;
            }
        }

        return completeComponents;
    }

    private void dfs(int node, List<List<Integer>> graph, boolean[] visited, int[] componentStats) {
        visited[node] = true;
        componentStats[0]++;
        componentStats[1] += graph.get(node).size();

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited, componentStats);
            }
        }
    }
}