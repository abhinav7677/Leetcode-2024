class Solution {

private:
bool countIsland(int i, int j, vector<vector<int>>& grid2, vector<vector<int>>& visited2, vector<vector<int>>& grid1) {
    // Out of Bounds
    if (i < 0 || j < 0 || i >= grid2.size() || j >= grid2[0].size()) {
        return true;
    }

    // It has been visited or it is land
    if (visited2[i][j] == 1 || grid2[i][j] == 0) {
        return true;
    }

    if (grid1[i][j] == 0) {
        return false;
    }

    // Mark that location has been visited
    visited2[i][j] = 1;

    int up = countIsland(i + 1, j, grid2, visited2, grid1);
    int down = countIsland(i - 1, j, grid2, visited2, grid1);
    int left = countIsland(i, j + 1, grid2, visited2, grid1);
    int right = countIsland(i, j - 1, grid2, visited2, grid1);

    return (up && down && left && right);
}


public:
    int countSubIslands(vector<vector<int>>& grid1, vector<vector<int>>& grid2) {
        vector<vector<int>> visited2(grid2.size(), vector<int>(grid2[0].size(), 0));

        int count = 0;
        for (int i = 0; i < grid2.size(); i++) {
            for (int j = 0; j < grid2[0].size(); j++) {
                if (grid2[i][j] == 1 && visited2[i][j] == 0) {
                    if (countIsland(i, j, grid2, visited2, grid1)) {
                        count++;
                    }
                }
             }
        }
        return count;
    }
};
