class Solution {
public:
int solve(vector<int>&v,int h)
{
    int n=v.size();
sort(v.begin(),v.end());
int x=abs(v[v.size()-1]-v[0]);
if(x<=h)
return n;
return 0;
}
    int longestSubarray(vector<int>& nums, int limit) {
        int n=nums.size();
       int maxi=INT_MIN;
       int i=0;int j=0;  int x=0;
       priority_queue<pair<int,int>>pq1;
       priority_queue<pair<int,int>,vector<pair<int,int>>,greater<pair<int,int>>>pq2;
       while(j<n)
       {
        pq1.push({nums[j],j});
        pq2.push({nums[j],j});
      x=abs(pq1.top().first-pq2.top().first);
        if(x>limit)
        {
              i++;
        while(pq1.top().second<i)
        {
           pq1.pop();  
        }
         while(pq2.top().second<i)
        {
           pq2.pop();  
        }
        }
        if(x<=limit)
        {
            maxi=max(maxi,j-i+1);
        }
        j++;
       }
        return maxi;
    }
}; 