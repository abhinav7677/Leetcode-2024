class Solution {
    public int findMaxK(int[] nums) {

     Arrays.sort(nums);
    
     for(int i= nums.length- 1; i>= 0; i--)
     {
        int k= nums[i];
       for(int j= 0; j< i; j++)
       {
        int negativeK= nums[j];
        if(negativeK== k*-1)
        {
            return k;
        }
       }
     }
        return -1;
    }
}