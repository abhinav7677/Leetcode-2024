class Solution {
    public int[] rearrangeArray(int[] nums) {
     int[] outArr = new int[nums.length];
     int posInd=0;
     int negInd=1;

     for(int i=0; i<nums.length; i++) {
         if(nums[i]>0) {
             outArr[posInd] = nums[i];
             posInd += 2;
         } else {
             outArr[negInd] = nums[i];
             negInd += 2;
         }
     } 
     return outArr;

    }
}