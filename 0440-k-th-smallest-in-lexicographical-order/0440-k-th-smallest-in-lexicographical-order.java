class Solution {
    public int findKthNumber(int n, int k) {
        int current = 1;
        k -= 1; // since we start from 1

        while (k > 0) {
            long steps = calSteps(n, current, current + 1);
            if (steps <= k) {
                current += 1;
                k -= steps;
            } else {
                current *= 10;
                k -= 1;
            }
        }

        return current;
    }

    private long calSteps(int n, long curr, long next) {
        long steps = 0;
        while (curr <= n) {
            steps += Math.min((long) n + 1, next) - curr;
            curr *= 10;
            next *= 10;
        }
        return steps;
    }
}