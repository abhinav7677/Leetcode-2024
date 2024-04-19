class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        int count = 0;
        for(int i=0; i<grid.size(); ++i) {
            for(int j = 0; j<grid[0].size(); ++j) {
                if(grid[i][j] == '1') {
                    count++;
                    cancelIslands(grid, i, j);
                }
            }
        }
        return count;
    }

    void cancelIslands(vector<vector<char>>& grid, int i, int j) {
        int m = grid.size();
        int n = grid[0].size();
        if(i<0 || j<0 || i>=m || j>= n || grid[i][j] == '0') {

        } else {
            grid[i][j] = '0';
            cancelIslands(grid, i, j+1);
            cancelIslands(grid, i+1, j);
            cancelIslands(grid, i, j-1);
            cancelIslands(grid, i-1, j);
        }
    }
};