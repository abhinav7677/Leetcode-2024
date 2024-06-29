class Solution {
public:

    long long maximumImportance(int n, vector<vector<int>>& roads) {
        map<int, int> occ;
        long long ans = 0;

        for(int i = 0 ; i < roads.size();i++){
            occ[roads[i][0]]++;
            occ[roads[i][1]]++;
        }
        multimap<int,int> mp;
        for(auto p : occ){
            mp.insert({p.second , p.first});
        }

        map<int, int> values;
        int N= n;
        for(auto it = mp.rbegin(); it != mp.rend();it++){
            values[it->second] = N--;
        }

        for(int i = 0;i < roads.size();i++){
            ans += values[roads[i][0]] + values[roads[i][1]];
        }

        return ans;
    }
};