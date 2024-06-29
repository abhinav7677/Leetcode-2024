class Solution {
public:
    void dfs(int i,int &curr,vector<vector<int>>&dp,vector<int>&vis,vector<vector<int>> &ans) {
        vis[i]=1;
        for(int child:dp[i]){
            if(vis[child])continue;
            ans[child].push_back(curr);
            dfs(child,curr,dp,vis,ans);
        }
    }
    vector<vector<int>> getAncestors(int n, vector<vector<int>>& edges) {
        vector<vector<int>> dp(n);
        vector<vector<int>>ans(n);
        for (auto ed : edges) {
            dp[ed[0]].push_back(ed[1]);
        }
        vector<int>vis(n,0);
        for (int i = 0; i < n; i++) {
            dfs(i,i,dp,vis,ans);
            vis.assign(n,0);
        }
        return ans;
    }
};