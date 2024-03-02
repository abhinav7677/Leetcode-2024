class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int i = n-1;
        int l=0, r=n-1;
        while(l <= r) {
            int sq = 0;
            int nl = nums[l], rh = nums[r];
            if(Math.abs(nl) > Math.abs(rh)) {
                sq = nl;
                l++;
            } else {
                sq = rh;
                r--;
            }
            res[i--] = sq * sq;
        }
        return res;
    }
}