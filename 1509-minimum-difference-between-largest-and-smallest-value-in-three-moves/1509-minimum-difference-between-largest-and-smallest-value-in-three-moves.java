class Solution {
    public int minDifference(int[] nums) {
        if(nums.length <= 3) return 0;
        Arrays.sort(nums);
        int l = nums.length, w = l - 3, ans = nums[l-1]-nums[0], i = 0;
        while(i <= l - w) ans = Math.min(ans, nums[i + w - 1] - nums[i++]);
        return ans;
    }
}