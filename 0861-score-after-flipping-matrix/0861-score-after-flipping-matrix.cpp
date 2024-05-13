class Solution {
public:
    int matrixScore(vector<vector<int>>& grid) {
        int n=grid.size(),m=grid[0].size();

        for(int i=0;i<n;i++){
            if(grid[i][0]==0){
                for(int j=0;j<m;j++){
                    if(grid[i][j]==0) grid[i][j]=1;
                    else grid[i][j]=0;
                }
            }
        }
        int j=1;

        while(j<m){
            int cnt=0;
            for(int i=0;i<n;i++){
                if(grid[i][j]==0) cnt++;
            }
            int k;
            if(n%2==0) k=n/2;
            else k=(n/2)+1;
            if(cnt>=k){
                for(int i=0;i<n;i++){
                    if(grid[i][j]==0) grid[i][j]=1;
                    else grid[i][j]=0;
                }
            }
            j++;
        }
        int ans=0;

        for(auto i:grid){
            int pw=m-1,temp=0;

            for(auto j:i){
                if(pw>=0) temp+=j*(1<<pw);
                pw--;
            }
            ans+=temp;
        }
        return ans;

    }
};