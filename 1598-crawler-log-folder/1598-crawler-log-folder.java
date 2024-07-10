class Solution {
    public int minOperations(String[] logs) {
        int result=0;
        for(String log:logs){
            if(log.equals("../")){
                if(result==0){
                    continue;
                }else{
                    result--;
                }             
            }
            else if(log.equals("./")){
                continue;
            }else{
                result++;
            }
        }
        return result;
    }
}