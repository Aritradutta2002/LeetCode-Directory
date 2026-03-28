class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int connectedComponent = countConnectedDFS(isConnected, n);
        return connectedComponent;
    }

    public int countConnectedDFS(int[][] connected, int n) {
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, visited, connected);
                count++;
            }
        }
        return count;
    }

    public void dfs(int node, boolean[] visited, int[][] connected) {
        int n = connected.length;
        visited[node] = true;
        for (int neighbor = 0; neighbor < n; neighbor++) {
            if (connected[node][neighbor] == 1 && !visited[neighbor]) {
                dfs(neighbor, visited, connected);
            }
        }
    }
}