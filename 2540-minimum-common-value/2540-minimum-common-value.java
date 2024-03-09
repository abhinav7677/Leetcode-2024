class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int p = 0, q = 0;
        int m = nums1.length, n = nums2.length;
        while(p<m && q <n){
            if(nums1[p] == nums2[q]){
                return nums1[p];
            }
            else if(nums1[p] > nums2[q]){
                q++;
            }
            else{
                p++;
            }
        }
        return -1;
    }
}