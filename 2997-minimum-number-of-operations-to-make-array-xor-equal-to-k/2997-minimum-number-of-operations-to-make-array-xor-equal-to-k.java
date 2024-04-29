class Solution {
    public int minOperations(int[] nums, int k) {
        int xor=0;
        for(int i: nums)
            xor^=i;
        int res = 0;
        for(int i=0 ;i <32; i++){
            if(((xor>>i)&1) != ((k>>i)&1))
                res++;
        }
        return res;
    }
}