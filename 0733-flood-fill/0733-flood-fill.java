class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int origin = image[sr][sc];
        if (origin == color) return image;
        dfs(origin, sr, sc, image, color);
        return image;
    }

    public void dfs(int origin, int r, int c, int[][] image, int color) {
        if (r < 0 || r >= image.length) return;      // ← stops dfs itself
        if (c < 0 || c >= image[0].length) return;
        if (image[r][c] != origin) return;

        image[r][c] = color;
        dfs(origin, r + 1, c, image, color); // Down
        dfs(origin, r - 1, c, image, color); // UP
        dfs(origin, r, c + 1, image, color); // Right
        dfs(origin, r, c - 1, image, color); // Left 
    }
}