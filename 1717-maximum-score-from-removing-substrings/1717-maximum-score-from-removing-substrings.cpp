class Solution {
public:
    int maximumGain(string s, int x, int y) {
        int total = 0;
        string targetX = "ab";
        string targetY = "ba";

        if(x < y){
            x = y ^ x;
            y = x ^ y;
            x = y ^ x;

            targetX = "ba";
            targetY = "ab";
        }

        total += removeString(s, targetX, x);
        total += removeString(s, targetY, y);

        return total;
    }

    int removeString(string& input, string target, int points){
        int writeIndex = 0;
        int total = 0;

        for(int i = 0; i < input.size(); i++){
            input[writeIndex++] = input[i];

            if(writeIndex > 1 &&  input[writeIndex - 2] == target[0] && input[writeIndex - 1] == target[1]) {
                writeIndex -= 2;
                total += points;
            }
        }

        input.erase(input.begin() + writeIndex, input.end());

        return total;
    }
};