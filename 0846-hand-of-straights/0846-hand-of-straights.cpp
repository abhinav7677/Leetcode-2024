class Solution {
public:

    bool isNStraightHand(vector<int>& hand, int groupSize) {
        
        int n = hand.size();
        unordered_map<int,int> freq;
        for(int i=0;i<n;i++) freq[hand[i]]++;
        sort(hand.begin(),hand.end());
        int i = 0;

        while(i < n){

            int count = groupSize-1;

            while(i < n && freq.find(hand[i]) == freq.end()){
                i++;
                if(i >= n) return true;
            }

            int prev = hand[i];
            freq[prev]--;
            if(freq[prev] == 0){
                freq.erase(prev);
            }

            while(count){

                if(freq.find(prev+1) == freq.end()){
                    return false;
                }else{
                    prev++;
                    count--;
                    freq[prev]--;
                    if(freq[prev] == 0){
                        freq.erase(prev);
                    }
                }

            }

        }

        return true;

    }
};