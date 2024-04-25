class Solution {
    public int fxn(String s,int k,int idx,char prev,int dp[][]){
        if(idx>s.length()-1){
            return 0;
        }
        if(dp[idx][prev-'a']!=-1){
            return dp[idx][prev-'a'];
        }
        int ans1=0;
        int ans2=0;
        if(prev=='{' || Math.abs((int)s.charAt(idx)-(int)(prev))<=k){
            ans1=1+fxn(s,k,idx+1,s.charAt(idx),dp);
            ans2=fxn(s,k,idx+1,prev,dp);
        }else{
            ans2=fxn(s,k,idx+1,prev,dp);
        }
        return dp[idx][prev-'a']=Math.max(ans1,ans2);
    }
    public int longestIdealString(String s, int k) {
        int dp[][]=new int[s.length()][27];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                dp[i][j]=-1;
            }
        }
        return fxn(s,k,0,'{',dp);
    }
}