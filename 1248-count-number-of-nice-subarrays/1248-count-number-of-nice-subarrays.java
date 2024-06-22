class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        LinkedList<Integer> dq=new LinkedList<>();
        int res=0;
        dq.add(-1);
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]%2==1)
            {
                dq.add(i);
            }
            if(dq.size()>k+1)
            {
                dq.pop();
            }
            if(dq.size()==k+1)
            {
                res+=dq.get(1)-dq.get(0);
            }
        }
    return res;

    }
}