class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<matrix.length;i++){
            int min=Integer.MAX_VALUE;
            int index=0;

            for (int j=0;j<matrix[i].length;j++){
                if (matrix[i][j]<min){
                    min=matrix[i][j];
                    index=j;
                }
            }

            if(ismax(matrix,min,index)){
                System.out.println(min);
                list.add(min);
            }
        }
        return list;
    }

    public boolean ismax(int[][] matrix, int min, int index){
        for (int i=0;i<matrix.length;i++){
            if (matrix[i][index]>min){
                return false;
            }
        }
        return true;
    }
}