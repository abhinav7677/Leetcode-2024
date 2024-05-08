class Solution {
    public String[] findRelativeRanks(int[] score) {
        String arr[]=new String[score.length];
       for(int i=0;i<score.length;i++){
        int c=0;
        for(int j=0;j<score.length;j++){
            
        if(score[j]>score[i]){
            c++;
        }
       } 
       if(c==0){
        arr[i]="Gold Medal";

       }
       else if(c==1){
        arr[i]="Silver Medal";
        
       }
       else if(c==2){
        arr[i]="Bronze Medal";
       }
       else{
        arr[i]=c+1+"";
       }
       }
       return arr; 
    }
}