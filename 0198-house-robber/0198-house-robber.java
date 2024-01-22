class Solution {
    int money(int[] nums ,int i,int [] dp){
        if(i>=nums.length) return 0;
        int sum = 0;
        if(dp[i]!=-1) return dp[i];
        int Rob = sum + nums[i] + money(nums,i+2,dp);
        int notRob = sum + money(nums,i+1,dp);
        return dp[i]=Math.max(Rob,notRob);
    }
    public int rob(int[] nums) {
        int [] dp = new int [nums.length];
        for(int i=0 ; i<nums.length ; i++){
            dp[i] = -1;
        }
        return money(nums,0,dp);
    }
}