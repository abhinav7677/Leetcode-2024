
class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int rightbar=height[n-1];
        int leftbar=height[0];
        int l=0;
        int r=n-1;
        int ans=0;
        while(l<=r){
            if(leftbar<rightbar){
                if(leftbar<height[l]){
                    leftbar=height[l];
                }else{
                    ans+=leftbar-height[l];
                    l++;
                }
            }else{
                  if(rightbar<height[r]){
                    rightbar=height[r];
                }else{
                    ans+=rightbar-height[r];
                    r--;
                }
            }

        }
        return ans;
    }
}