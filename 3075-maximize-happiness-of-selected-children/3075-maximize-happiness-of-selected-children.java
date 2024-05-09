class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        int size = happiness.length;
        Arrays.sort(happiness);
        long sum = 0;
        int count = 0;
        for (int i = size - 1; i >= size - k; i--) {
            if (happiness[i] - count <= 0)
                break;
            sum = sum + (long)Math.max(happiness[i] - count, 0);
            count++;
        }
        return sum;
    }
}