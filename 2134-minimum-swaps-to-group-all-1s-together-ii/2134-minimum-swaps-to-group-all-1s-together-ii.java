class Solution {
    public int minSwaps(int[] nums) {
        // Count the total number of '1'
        int ones = 0;
        for (int num : nums) {
            ones += num;
        }
        if (ones == 0) {
            return 0;
        }
        
        // Create the sliding window
        int zeros = 0; // The number of zeros in the window
        // Initialize the zeros in the window
        for (int i = 0; i < ones; i++) {
            if (nums[i] == 0) {
                zeros++;
            }
        }

        int res = zeros;
        for (int i = 1; i < nums.length; i++) {
            int right = (i + ones - 1) % nums.length;
            if (nums[i - 1] == 0) {
                zeros--;
            }
            if (nums[right] == 0) {
                zeros++;
            }
            res = Math.min(res, zeros);
        }

        return res;
    }
}