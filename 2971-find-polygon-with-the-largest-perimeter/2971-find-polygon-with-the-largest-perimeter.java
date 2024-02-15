class Solution {
    public long largestPerimeter(int[] nums) {
        long sum = Arrays.stream(nums).asLongStream().sum();
        Arrays.sort(nums);
        for(int i = nums.length-1; i >= 2; i--){
            sum -= nums[i];
            if(sum > nums[i]){
                return sum + nums[i];
            }
        }
        return -1;
    }
}
