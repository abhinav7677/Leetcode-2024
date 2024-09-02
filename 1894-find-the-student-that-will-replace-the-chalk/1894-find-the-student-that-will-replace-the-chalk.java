class Solution {
    public int chalkReplacer(int[] chalk, int k) {
       long sum=0;
       int n=chalk.length;
       for(int i=0;i<n;i++){
        sum+=chalk[i];
          }
        int remainingChalk =(int)(k% sum);
     
        for(int i=0;i<n;i++){
            if(remainingChalk < chalk[i]){
                return i;
            }
            remainingChalk-=chalk[i];
        }
       
       return -1; 
    }
}