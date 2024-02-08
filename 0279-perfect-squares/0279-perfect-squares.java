import java.util.Arrays;

class Solution {
    public int numSquares(int n) {
        // Create an array to store the least number of perfect squares that sum to i
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        // Base case: 0 requires 0 perfect squares
        dp[0] = 0;
        
        // Iterate through all numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            // Iterate through all possible squares smaller than or equal to i
            for (int j = 1; j * j <= i; j++) {
                // Update dp[i] if a smaller number of perfect squares is found
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        
        return dp[n];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.numSquares(12)); // Output: 3
        System.out.println(sol.numSquares(13)); // Output: 2
    }
}