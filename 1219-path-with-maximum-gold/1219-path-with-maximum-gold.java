class Solution {

    private int maxGold = 0; // Variable to keep track of maximum gold collected

    public int getMaximumGold(int[][] grid) {
        int rows = grid.length; // Number of rows in the grid
        int cols = grid[0].length; // Number of columns in the grid

        // Iterate over each cell in the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) // Skip cells with zero gold
                    continue;

                // Start a path from the current cell and update maxGold
                maxGold = Math.max(maxGold, traversePath(i, j, grid, rows, cols));
            }
        }

        return maxGold; // Return the maximum gold collected
    }

    int traversePath(int x, int y, int[][] grid, int rows, int cols) {
        boolean outside = x < 0 || x >= rows || y < 0 || y >= cols; // Check if out of grid bounds

        if (outside || grid[x][y] == 0) // If out of bounds or cell has zero gold, return 0
            return 0;

        int currGold = grid[x][y]; // Current cell's gold
        grid[x][y] = 0; // Mark current cell as visited by setting its gold to 0

        int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } }; // Four possible directions

        int maxGoldCollected = 0;

        // Explore all four directions
        for (int[] dir : directions) {
            int dx = dir[0];
            int dy = dir[1];

            int goldCollected = traversePath(x + dx, y + dy, grid, rows, cols);
            maxGoldCollected = Math.max(goldCollected, maxGoldCollected); // Update maximum gold collected
        }

        grid[x][y] = currGold; // Restore the current cell's gold value
        return maxGoldCollected + currGold; // Return total gold collected from this path
    }
}
