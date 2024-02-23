class Solution {
public:
    int findCheapestPrice(int n, vector<vector<int>>& flights, int src, int dst, int k) {
        unordered_map<int,vector<pair<int,int>>>mp;
        for(vector<int>&a : flights)
        {
            int u=a[0];
            int v=a[1];
            int cost=a[2];

            mp[u].push_back({v,cost});
        }

        queue<pair<int,int>>q;
        vector<int>distance(n,INT_MAX);
        q.push({src,0});
        distance[src]=0;
        int steps=0;
        while(!q.empty())
        {
            if(steps>k)
            {
                break;
            }
            int size=q.size();
            while(size--)
            {
                int u=q.front().first;
                int cost=q.front().second;
                q.pop();
                for(pair<int,int>&p: mp[u])
                {
                    int v=p.first;
                    int c=p.second;
                    if(distance[v]>cost+c)
                    {
                        distance[v]=cost+c;
                        q.push({v,cost+c});
                    }
                }
            }
            steps++;
        }
        if(distance[dst]==INT_MAX)
        {
            return -1;
        }
        return distance[dst];
        
    }
};