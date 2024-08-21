class Solution {
    public int stoneGameII(int[] piles) {
        // Initialize a memoization array with -1 (indicating uncomputed states)
        int[][][] memo = new int[piles.length][piles.length + 1][2];
        for (int i = 0; i < piles.length; i++) {
            for (int j = 0; j <= piles.length; j++) {
                memo[i][j][0] = -1;
                memo[i][j][1] = -1;
            }
        }

        return f(piles, 0, 1, 0, memo);
    }

    // player: 0 = Alice, 1 = Bob
    public int f(int[] piles, int ind, int m, int player, int[][][] memo) {
        if (ind == piles.length) {
            return 0;
        }

        // If the value is already computed, return it
        if (memo[ind][m][player] != -1) {
            return memo[ind][m][player];
        }

        int n = piles.length;
        if (player == 1) {
            int minScore = Integer.MAX_VALUE;

            for (int i = ind; i < ind + m * 2 && i < n; i++) {
                int temp = f(piles, i + 1, Math.max(m, i - ind + 1), 0, memo);
                minScore = Math.min(minScore, temp);
            }

            // Memoize the result for Bob's turn
            memo[ind][m][player] = minScore;
            return minScore;
        } else {
            int maxScore = 0;
            int prefix = 0;

            for (int i = ind; i < ind + m * 2 && i < n; i++) {
                prefix += piles[i];
                int temp = prefix + f(piles, i + 1, Math.max(m, i - ind + 1), 1, memo);
                maxScore = Math.max(maxScore, temp);
            }

            // Memoize the result for Alice's turn
            memo[ind][m][player] = maxScore;
            return maxScore;
        }
    }
}