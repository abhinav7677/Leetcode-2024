class Solution {
    public int longestCommonSubsequence(String text1, String text2) {

        int M = text1.length();
        int N = text2.length();

        int[][] dp = new int[M+1][N+1];

        for(int i=0;i<dp.length;++i){
            dp[i][0]=0;
        }

        for(int j=0;j<dp[0].length;++j){
             dp[0][j]=0;
        }

        for(int row=1;row<=M;++row){
            for(int col=1;col<=N;++col){
                
                if(text1.charAt(row-1)==text2.charAt(col-1)){
                    dp[row][col] = 1+dp[row-1][col-1];
                    continue;
                }

                dp[row][col] = Math.max(dp[row-1][col],dp[row][col-1]);

            }
        }

        for(int[] temp:dp){
            System.out.println(Arrays.toString(temp));
        }

        return dp[M][N];
        
    }
}