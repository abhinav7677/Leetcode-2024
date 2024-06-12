class Solution {
    public void sortColors(int[] nums) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                swap(nums, left, right); left++;
            }
        }
        for (int right = left; right < nums.length; right++) {
            if (nums[right] == 1) {
                swap(nums, left, right); left++;
            }
        }
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}