class Solution {
    public int appendCharacters(String s, String t) {
        int n = s.length() ;
        int m = t.length() ;
        int c = 0;
        for(int i=0, j=0; i<n && j<m; ){
            if(s.charAt(i) == t.charAt(j)){
                i++;
                j++;
                c++;
            }
            else{
                i++ ;
            }
        }
        return m - c ;
    }
}