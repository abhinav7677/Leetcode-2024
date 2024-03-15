class Solution {
    public int[] productExceptSelf(int[] nums) {
        int zeros = 0;
        int indexZero = -1;
        int product = 1;
        for(int i = 0; i < nums.length && zeros < 2; i++){
            if(nums[i] == 0) {
                zeros++;
                indexZero = i;
            }
            else product *= nums[i];
        }

        if(zeros >= 2) {
            Arrays.fill(nums, 0);
            return nums;
        }

        if(zeros == 1){
            Arrays.fill(nums, 0);
            nums[indexZero] = product;
            return nums;
        }

        for(int i = 0;i < nums.length; i++){
            nums[i] = product / nums[i];
        }

        return nums;
    }
}