class Solution {
public:
    int specialArray(std::vector<int>& nums) {
        std::sort(nums.begin(), nums.end());
        
        int len = nums.size();
        for (int x = len; x > 0; x--) {
            int index = len - x;
            if (nums[index] >= x) {
                int i = index - 1;
                for (; i >= 0; i--) {
                    if (nums[i] >= x) {
                        break;
                    }
                }
                if (i == -1) {
                    return x;
                }
            }
        }
        return -1;
    }
};