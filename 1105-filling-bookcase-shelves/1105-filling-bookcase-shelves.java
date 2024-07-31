class Solution {
    long dp[];
    int maxW;
    public long helper(int[][] books,int i){
        if(i==books.length) {
            return 0;
        }
        if(dp[i]==-1) {
        long min = Integer.MAX_VALUE;
        long max = 0;
        int j = i;
        int currW = maxW;
        while(j<books.length && (currW-books[j][0])>=0) {
            max = Math.max(max,books[j][1]);
            currW = currW - books[j][0];
            min = Math.min(min,max+helper(books,j+1));
            j++;
        }
        dp[i] = min;
        }
        return dp[i];
    }
    public int minHeightShelves(int[][] books, int shelfWidth) {
        dp = new long[books.length];
        Arrays.fill(dp,-1);
        maxW = shelfWidth;
        return (int)helper(books,0);
    }
}