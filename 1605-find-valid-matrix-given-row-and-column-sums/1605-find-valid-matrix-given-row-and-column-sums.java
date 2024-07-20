class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int n=rowSum.length;
        int m=colSum.length;
        int[][] mat=new int[n][m];
        int i=0,j=0;
        int r=0,c=0;
        while(i<n&&j<m){
            mat[i][j]=Math.min(rowSum[r],colSum[c]);
            rowSum[r]=rowSum[r]-mat[i][j];
            colSum[c]=colSum[c]-mat[i][j];
            if(rowSum[r]==0){
                r++;
                i++;
            }
            else{
                c++;
                j++;
            }


        }
        return mat;
        
    }
}