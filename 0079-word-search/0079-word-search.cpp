class Solution {
public:
    bool exist(vector<vector<char>>& board, string word) {
      int m = board.size();
    int n = board[0].size();

    // Define the DFS helper function
    function<bool(int, int, int)> dfs = [&](int i, int j, int k) {
        if (k == word.size()) return true;
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != word[k]) return false;
        char temp = board[i][j];
        board[i][j] = '#';
        bool found = dfs(i + 1, j, k + 1) || dfs(i - 1, j, k + 1) || dfs(i, j + 1, k + 1) || dfs(i, j - 1, k + 1);
        board[i][j] = temp;
        return found;
    };

    // Iterate through each cell in the grid to start the search
    for (int i = 0; i < m; ++i) {
        for (int j = 0; j < n; ++j) {
            if (dfs(i, j, 0)) return true;
        }
    }

    return false;
}

int main() {
    vector<vector<char>> board = {
        {'A', 'B', 'C', 'E'},
        {'S', 'F', 'C', 'S'},
        {'A', 'D', 'E', 'E'}
    };
    string word = "ABCCED";

    cout << "Word exists in the grid: " << (exist(board, word) ? "true" : "false") << endl;

    return 0;   
    }
};