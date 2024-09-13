class Solution {
    public static int findXOR(int arr[],int first,int last)
    {
        if(first==last)
        {
            return arr[first];
        }
        int xor=0;
        for(int i=first;i<=last;i++)
        {
            xor^=arr[i];
        }
        return xor;
    }
    public int[] xorQueries(int[] arr, int[][] queries) {
        int res[]=new int[queries.length];
        for(int i=0;i<queries.length;i++)
        {
            int left=queries[i][0];
            int right=queries[i][1];
            res[i]=findXOR(arr,left,right);
        }
        return res;
    }
}