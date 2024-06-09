class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int res = 0;
        int[] freq = new int[k]; // The frequency of prefix sum remainders
        int prefix = 0; // The prefix sum from the beginning to current element

        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];
            prefix %= k;

            // Convert the prefix remainder to corresponding positive remainder if it is negative
            if(prefix < 0) {
                prefix += k;
            }

            res += freq[prefix];
            freq[prefix]++;
            if(prefix == 0) {
                res++;
            }
        }

        return res;
    }
}