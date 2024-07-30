class Solution {
    public int minimumDeletions(String s) {
        int count = 0;
        int res =0;
        for(char c:s.toCharArray()){
            if(c == 'b'){
                count++;
            }else if(count != 0){
                count--;
                res++;
            }
        }
        return res;
    }
} 