class Solution {
    public int cherryPickup(int[][] grid) {

     final int m = grid.length;
     final int n = grid[0].length;
     int[][][] nes = new int[m][n][n];

      for(int[][] Ans : nes)
       Arrays.stream(Ans).forEach(A -> Arrays.fill(A, -1));
       
      return charryPickProcess(grid, 0, 0, n-1, nes); 
    }

    private int charryPickProcess(int[][] grid, int x, int y, int z, int[][][]nes)
    {   
        if(x == grid.length)
          return 0;

        if(y < 0 || y == grid[0].length || z < 0 || z == grid[0].length)
          return 0;

        if(nes[x][y][z] != -1)
          return nes[x][y][z];
 
       final int currRow = grid[x][y]+(y == z ? 0 : grid[x][z]);

        for(int d1 = -1; d1 <=1; ++d1)
         for(int d2 =-1; d2 <=1; ++d2)
           nes[x][y][z] = Math.max(nes[x][y][z], currRow + charryPickProcess(grid, x+1, y+d1, z+d2, nes)); 

     return nes[x][y][z];
    }
}