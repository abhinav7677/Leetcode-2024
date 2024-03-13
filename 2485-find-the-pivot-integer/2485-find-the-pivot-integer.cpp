class Solution {
public:
    int pivotInteger(int n) {
        int ans = -1;
        int total_sum = 0;
        int curr_sum = 0;
// Total_sum form 1 to n 
        for(int i = 1; i<=n; i++){
            total_sum +=i;
        }
// curr_sum will be running sum
        for(int i = 1; i<=n; i++){
            curr_sum = curr_sum + i;
            if(total_sum == curr_sum){
                ans = i; // storing index value as ans 
                break;
            }else{
                total_sum = total_sum - i; // subtracting every time with i
            }
        }
      return ans;
    }
};