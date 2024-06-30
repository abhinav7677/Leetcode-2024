class Solution {
private:
    // find connected components on the graph made of just type_3 edges
    void bfs_find_cc3(int src, int &icc, vector<int>& cc, vector<vector<pair<int, int>>>& graph) {
        std::queue<int> bfs;
        bfs.push(src);

        cc[src] = icc;

        while (!bfs.empty()) {
            int cnode = bfs.front();
            bfs.pop();

            for (auto edge: graph[cnode]) {
                int node = edge.first;
                int type = edge.second;

                if (type != 3) {
                    continue;
                }

                if (cc[node] != 0) {
                    continue;
                }

                cc[node] = icc;
                bfs.push(node);
            }
        }

        ++icc;
    }

    // check if graph is connected using edges for both alice and bob
    bool bfs_connected(int src, vector<int>&vis, vector<vector<pair<int, int>>>& graph) {
        std::queue<int> bfs_1;
        std::queue<int> bfs_2;

        bfs_1.emplace(src);
        bfs_2.emplace(src);

        vis[src] = 0b11;

        const int FILTER_1 = 0b01;
        const int FILTER_2 = 0b10;

        while (!bfs_1.empty() && !bfs_2.empty()) {
            int top1 = bfs_1.front();
            int top2 = bfs_2.front();
            bfs_1.pop();
            bfs_2.pop();

            for (auto edge: graph[top1]) {
                if ((edge.second & FILTER_1) == 0) {
                    continue;
                }

                int node = edge.first;
                if (vis[node] & FILTER_1) {
                    continue;
                }

                bfs_1.push(node);
                vis[node] |= FILTER_1;
            }

            for (auto edge: graph[top2]) {
                if ((edge.second & FILTER_2) == 0) {
                    continue;
                }

                int node = edge.first;
                if (vis[node] & FILTER_2) {
                    continue;
                }

                bfs_2.push(node);
                vis[node] |= FILTER_2;
            }
        }

        for (int i = 1; i < graph.size(); ++i) {
            if (vis[i] != (FILTER_1 | FILTER_2)) {
                return false;
            }
        }

        return true;
    }

public:
    int maxNumEdgesToRemove(int n, vector<vector<int>>& edges) {
        vector<vector<pair<int, int>>> graph(1 + n);

        for (auto edge: edges) {
            graph[edge[1]].emplace_back(edge[2], edge[0]);
            graph[edge[2]].emplace_back(edge[1], edge[0]);
        }

        vector<int> vis(1 + n, 0);
        if (!bfs_connected(1, vis, graph)) {
            return -1;
        }
 
        vector<int> cc_type3(1 + n, 0);
        int icc = 1;
        for (int i = 1; i <= n; ++i) {
            if (cc_type3[i] != 0) {
                continue;
            }

            bfs_find_cc3(i, icc, cc_type3, graph);
        }

        int num_components = -1 + icc;
        int num_t3_edges = n - num_components; // each component has <size - 1> edges
        int remaining_edges = -1 + num_components; // one edge connects two components

        int total_remaining = num_t3_edges + 2 * remaining_edges;

        return edges.size() - total_remaining;
    }
};
