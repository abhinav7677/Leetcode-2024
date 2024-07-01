class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int c=0;
        int a=0,b=0;
        for(int i=0;i<arr.length-2;i++)
        {
            a=arr[i];
            b=arr[i+1];
            c=arr[i+2];
            if(a%2!=0&&b%2!=0&&c%2!=0)
            return true;
        }
        return false;
    }
}