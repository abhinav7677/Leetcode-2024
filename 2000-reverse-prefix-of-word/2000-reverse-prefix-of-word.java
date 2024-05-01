class Solution {
    public String reversePrefix(String word, char ch) {
        StringBuilder sb = new StringBuilder();
        int  count = 0;
        for(int i = 0; i<word.length(); i++){
            char c = word.charAt(i);
            
            if(ch!=c || (ch == c && count == 1)){
                sb.append(c);
            }
           else if(ch==c && count==0){
                   sb.append(c);
                   count++;
                   sb.reverse();
    
        }

        }
        return sb.toString();
    }
}