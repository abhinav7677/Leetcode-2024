class Solution {
    private int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    private int mod = (int)1e9+7;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] dp = new int[m+1][n+1][maxMove+1];
        for(int[][] ele : dp){
            for(int e[] : ele) Arrays.fill(e, -1);
        }
        return findPathsUtil(startRow, startColumn, m, n, maxMove,dp);
    }
    
     public int findPathsUtil(int sr, int sc, int er, int ec, int mm, int[][][] dp){
        if( sr < 0 || sc < 0 || sr >= er || sc >= ec ) return 1;
        if(mm == 0) return 0;
        if(dp[sr][sc][mm] != -1) return dp[sr][sc][mm];
        
        int count = 0;
        
        for(int d[] : dir){
            int r = sr + d[0];
            int c = sc + d[1];
            
            count = (count + findPathsUtil(r,c,er,ec, mm-1, dp))%mod;
        }
        return dp[sr][sc][mm] = count;
	}
}
