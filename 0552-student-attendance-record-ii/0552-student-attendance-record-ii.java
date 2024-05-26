class Solution {

    private static final int MOD = 1000000007;
    int n;
    int dp[][][];
    public int checkRecord(int n) {
        this.n = n;
        dp = new int[n][2][3];
        return getCombinations(0,false,0);
    }

    private int getCombinations(int i, boolean abs, int lateStreak){
        if(i==n){
            return 1;
        }

        if(dp[i][abs?1:0][lateStreak]!=0){
            return dp[i][abs?1:0][lateStreak];
        }

        int res = getCombinations(i+1,abs,0);

        if(!abs){
            res = (res+getCombinations(i+1,!abs,0))%MOD;
        }
        if(lateStreak<2){
            res = (res+getCombinations(i+1,abs,lateStreak+1))%MOD;
        }
        return dp[i][abs?1:0][lateStreak] = res;
    }
}