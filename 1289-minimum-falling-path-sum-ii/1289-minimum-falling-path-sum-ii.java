class Solution {
    public int minFallingPathSum(int[][] grid) {
        int min = Integer.MAX_VALUE;
        int n = grid.length;
        int[] curr = new int[n];
        int[] pre = new int[n];

        for(int i = 0; i < n; i++) {
            pre[i] = grid[n-1][i];
        }

        for(int row = n-2; row >= 0; row--) {
            curr = new int[n];
            for(int col = 0; col < n; col++) {
                int MinOfValidPaths = Integer.MAX_VALUE;
                for(int i = 0; i < n; i++) {
                    if(col == i) {
                        continue;
                    }
                    MinOfValidPaths = Math.min(MinOfValidPaths, pre[i]);
                }
                curr[col] = grid[row][col] + MinOfValidPaths;
            }
            pre = curr;
        }
        for(int i = 0; i < grid.length; i++) {
            min = Math.min(min, pre[i]);
        }
        return min;
    }
    
}