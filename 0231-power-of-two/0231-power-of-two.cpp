class Solution {
public:
    bool isPowerOfTwo(int n) {
        if(n==1){
            return true;
        }
        if(n==0){
            return false;
        }
        int p=0;
        while(n!=1){
            if(n%2!=0){
                p=5;
                break;
            }
            else{
                n/=2;
            }
        }
        if(p==5){
            return false;
        }
        return true;
    }
};