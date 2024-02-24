class Solution {
    struct myComp {
    constexpr bool operator()(
        pair<int, int> const& a,
        pair<int, int> const& b)
        const noexcept
    {
        return a.second > b.second;
    }
};
public:
    vector<int> findAllPeople(int n, vector<vector<int>>& meetings, int firstPerson) {

       vector<vector<pair<int,int>>> adj_m(n);
       priority_queue<pair<int,int>,vector<pair<int,int>>,myComp> knows_secret;

       knows_secret.push(make_pair(0,0));
       knows_secret.push(make_pair(firstPerson,0));
       for(int i=0;i<meetings.size();i++){
           adj_m[meetings[i][0]].push_back(make_pair(meetings[i][1],meetings[i][2]));
           adj_m[meetings[i][1]].push_back(make_pair(meetings[i][0],meetings[i][2]));
       } 
       set<int> ans;
       vector<bool> visited(n,false);
       while(knows_secret.size() > 0){
           pair<int,int> kn_curr = knows_secret.top();
           knows_secret.pop();
           int num = kn_curr.first;
           if(!visited[num]){
           ans.insert(num);
           
           visited[num] = true;
           int time = kn_curr.second;
           for(auto x : adj_m[num]){
               if(x.second >= time){
                   knows_secret.push(x);
               }
           }
           }
       }

       vector<int> ans_v;

       for(auto x : ans){
           ans_v.push_back(x);
       }
       
       return ans_v;

    }
};
