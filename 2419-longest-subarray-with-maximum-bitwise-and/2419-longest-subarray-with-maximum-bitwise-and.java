class Solution {
    public int longestSubarray(int[] nums) {
        
        int len = 0; int max = 0; int ans = 0;

        for(int item: nums){

            if(item > max){//new max item 

                max = item;
                
                ans = 0; 

                len = 0;

            }
            if(max == item){

                len++;

            }
            else{

                len = 0;

            }

            ans = Math.max(ans,len);

        }
        return ans;
    }
}