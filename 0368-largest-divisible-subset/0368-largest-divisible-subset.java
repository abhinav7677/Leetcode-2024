class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length, dp[] = new int[n], maxCount=1, maxIndex=0;
        Arrays.sort(nums);
        Arrays.fill(dp, 1);
        for(int i=0;i<n;++i){
            for(int j=0;j<i;++j){
                if(nums[i]%nums[j]==0){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    if(dp[i]>maxCount){
                        maxCount=dp[i];
                        maxIndex=i;
                    }
                }
            }
        }

        int  num=nums[maxIndex];
        List<Integer> res = new ArrayList<>();
        for(int i=maxIndex;i>=0;--i){
            if(num%nums[i]==0 && dp[i]==maxCount){
                res.add(nums[i]);
                num=nums[i];
                --maxCount;
            }
        }
        return res;
    }
}
