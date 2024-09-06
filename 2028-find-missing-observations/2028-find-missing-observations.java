class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        
        int incorrectsum=0,actualsum=0;
        for(int i=0;i<rolls.length;i++){
            incorrectsum+=rolls[i];
        }
        int missingsum=((rolls.length+n)*mean)-incorrectsum;
        
        if(missingsum<=0)
        return new int[0]; 
        
        int missing_array[]=new int[n];
        int count=0; // number of rounds in the missing array 
        while(missingsum>0){
            for(int i=0;i<n;i++){
                missing_array[i]+=1;
                missingsum--;
                
                if((count==0 && missingsum==0 && i!=n-1)|| (missing_array[i]>6))
                    return new int[0];

                if(missingsum==0 && (count!=0 || i==n-1))
                    return missing_array;
                }
                count++;
            }
            
        return missing_array;
    }
}