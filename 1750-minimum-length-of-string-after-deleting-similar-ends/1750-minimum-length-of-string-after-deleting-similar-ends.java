class Solution {
    public int minimumLength(String s) {
        int i=0;
        int j =s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                break;
            }
            if(s.charAt(i)==s.charAt(j)){

                char ch = s.charAt(i);

                int k=i;
                while(s.charAt(k)==ch){
                    k++;
                    if(k>s.length()-1){
                        return 0;
                    }
                }
                i=k;
                int l=j;
                while(s.charAt(l)==ch){
                    l--;
                    if(l<0){
                        return 0;
                    }
                }
                j=l; 
        }
    }
    if((j-i)<0){
        return 0;
    }
    return (j-i)+1;
    
    } 
}