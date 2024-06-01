class Solution {
    public int scoreOfString(String s) {
        int i=0;
        int j=1;
        int sum=0;
        while(j<s.length()){
            int first=(int)s.charAt(i);
            int second=(int)s.charAt(j);
            sum=sum+Math.abs(first-second);
            i++;
            j++;

        }
        return sum;
    }
}