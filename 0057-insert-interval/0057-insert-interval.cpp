class Solution {
public:
    vector<vector<int>> insert(vector<vector<int>>& intervals,
                               vector<int>& newInterval) {
        vector<vector<int>> ans;
        int n = intervals.size();
       // Break the code into parts
       int i=0;
       //1. When it is not overlapping
        while(i<n && intervals[i][1] < newInterval[0]){
            ans.push_back(intervals[i]);
            i++;
        }
        //2.When we found the interval
        while(i<n&& newInterval[1] >= intervals[i][0]){
            newInterval[0] = min(newInterval[0],intervals[i][0]);
            newInterval[1] = max(newInterval[1],intervals[i][1]);
            i++;
        }
        ans.push_back(newInterval);
        //3.Remaining intervals
        while(i<n)
        {
            ans.push_back(intervals[i]);
            i++;
        }
        return ans;

    }
}; 