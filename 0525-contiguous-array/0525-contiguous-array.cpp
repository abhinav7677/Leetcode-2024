class Solution {
public:
    int findMaxLength(vector<int>& nums) {
        int s=0,n=nums.size(),l=0;
        vector<int> v(n+1);
        v[0]=0;
        for(int i=0;i<n;i++)
            v[i+1]=v[i]+nums[i];
        for(int i=n;i>=2;i--)
            for(int j=i%2;j<i&&i-j>l;j+=2)
                if(v[i]-v[j]==(i-j)/2)
                {
                    l=max(l,i-j);
                    break;
                }
        return l;
    }
};