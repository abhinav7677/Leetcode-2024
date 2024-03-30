class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();
        Map<Integer, Integer> counter2 = new HashMap<>();

        int left = 0;
        int left2 = 0;
        int res = 0;

        for (int val : nums) {
            counter.merge(val, 1, Integer::sum);
            counter2.merge(val, 1, Integer::sum);

            while (counter.size() == k) {
                counter.merge(nums[left], -1, Integer::sum);
                if (counter.get(nums[left]) <= 0) {
                    counter.remove(nums[left]);
                }
                left++;
            }

            while (counter2.size() > k) {
                counter2.merge(nums[left2], -1, Integer::sum);
                if (counter2.get(nums[left2]) <= 0) {
                    counter2.remove(nums[left2]);
                }
                left2++;
            }

            res += left - left2; //right - left2 + 1 - (right - left + 1)
        }

        return res;
    }
}