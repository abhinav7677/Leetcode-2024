class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        HashSet<Integer> tempOut = new HashSet<>();
        int output = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(i+2<grid.length && j+2<grid[0].length){
                    tempOut = new HashSet<>();
                    int a = grid[i][j]+grid[i+1][j+1]+grid[i+2][j+2];
                    int b = grid[i+2][j]+grid[i+1][j+1]+grid[i][j+2];
                    int c = grid[i][j]+grid[i][j+1]+grid[i][j+2];
                    int d = grid[i+1][j]+grid[i+1][j+1]+grid[i+1][j+2];
                    int e = grid[i+2][j]+grid[i+2][j+1]+grid[i+2][j+2];
                     int f = grid[i][j]+grid[i+1][j]+grid[i+2][j];
                    int g = grid[i][j+1]+grid[i+1][j+1]+grid[i+2][j+1];
                    int h = grid[i][j+2]+grid[i+1][j+2]+grid[i+2][j+2];
                    if(a==b && b==c && c==d && d==e && e==f && f==g && g==h){
                        for(int z=i;z<=i+2;z++){
                            for(int y=j;y<=j+2;y++){
                                if(grid[z][y]<=9 && grid[z][y]>0) {
                                    tempOut.add(grid[z][y]);
                                }
                            }
                        }
                    }
                    if(tempOut.size()==9){
                        output++;
                    }
                }
            }
        }
        return output;
    }
}