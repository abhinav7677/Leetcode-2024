class Solution {
public:
    int bagOfTokensScore(vector<int> &tokens, int power) {
        std::sort(tokens.begin(), tokens.end());
        int max_score = 0;
        int score = 0;
        int left = 0;
        int right = tokens.size() - 1;

        while(left <= right) {
            if(power >= tokens[left]) {
                power -= tokens[left++];
                ++score;
                max_score = std::max(max_score, score);
                continue;
            }

            if(score > 0) {
                power += tokens[right--];
                --score;
                continue;
            }

            break;
        }

        return max_score;
    }
};