class Solution {
    int n;
    int m;
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        n=rows;
        m=cols;
        int steps=1;
        int[][] directions={{0,1},{1,0},{0,-1},{-1,0}};
        int r=rStart;
        int c=cStart;
        int k=0;
        List<int[]> arr=new ArrayList<>();
        while(arr.size()<rows*cols){
            for(int j=0;j<2;j++){
                for(int i=0;i<steps;i++){
                    if(r>=0 && c>=0 && r< n && c<m){
                        arr.add(new int[]{r,c});
                    }
                    r+=directions[k][0];
                    c+=directions[k][1];
                }
                k=(k+1)% 4;
            }
            steps++;
        }
        int[][] ans=new int[arr.size()][2];
        for(int i=0;i<arr.size();i++){
            ans[i]=arr.get(i);
        }
        return ans;
    }
}