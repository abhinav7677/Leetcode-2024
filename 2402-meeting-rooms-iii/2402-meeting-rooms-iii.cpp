class Solution {
public:
    int mostBooked(int n, vector<vector<int>>& meetings) {
       map<int,int> mp;
       priority_queue<int,vector<int>,greater<int>> q2;
       priority_queue<pair<long long,int>,vector<pair<long long,int>>,greater<pair<long long,int>>> q1;
       for(int i=0;i<n;i++){
           mp[i]=0;
           q2.push(i);
       } 

       sort(meetings.begin(),meetings.end());
      // int timer=meetings[0][0];
       for(int i=0;i<meetings.size();i++){
          int timer=meetings[i][0];
           int end=meetings[i][1];
           while(!q1.empty()&&timer>=q1.top().first){
               q2.push(q1.top().second);
               q1.pop();
           }
           if(q2.size()>0){
               mp[q2.top()]++;
               q1.push({meetings[i][1],q2.top()});
               q2.pop();
           }
           else{
              auto top=q1.top();
              int end1=top.first,index=top.second;
              mp[index]++;
              q1.pop();
              q1.push({top.first+end-timer,index});
           }
       }
       int ans,curr=0;
       for(auto x:mp){
           if(x.second>curr){
               ans=x.first;curr=x.second;
           }
       }
       return ans;
    }
};