class Solution {
    public int countSubstrings(String s) {
        int ans =0;
        for(int i=0; i<s.length(); i++){
           int even = expandFromCentre(s,i,i+1);
           int odd = expandFromCentre(s,i-1,i+1);
           ans+= even+odd+1;

        }
        return ans;
        
    }
    public int expandFromCentre(String s, int left, int right){
        int count =0;
        while(left>=0 && right<s.length() && s.charAt(left--) == s.charAt(right++)){
            count++;
        }
        return count;
    }
}