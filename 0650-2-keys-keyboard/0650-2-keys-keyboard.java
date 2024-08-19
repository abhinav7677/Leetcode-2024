class Solution {
    public int minSteps(int n) {
        
        //x is number of minimum steps
        int x=0,i=0; 
        
        //y is array which contains first few prime numbers
        int y[]= new int[]{2,3,5,7,11,13,17,19,23,29,31}; 
        
        //If n=1, return 0 as no need perform operations
        if(n==1) 
            return 0;
        
        //while loop until n>1
        while(n>1){

            //checks if n is divisible by any number present in array 
            if(n%y[i]==0){
                n/=y[i]; //if yes then divides n and overwrites n with quotient
                x+=y[i]; //adds that number to our x variable
            }

            //if n is not divisible by last number of array i.e. y[10]
            //return the sum of minimum step and the number
            else if(i==10)
                return x+n;
            
            // if n not divisible by current number &
            // i doesn't point to last value 
            //then increment i to check for other numbers
            else
                i++;      
        }
        //return the min number of steps at the end
        //which also means that n is divisible by number 
        //present inarray y 
        return x;
    }
}
