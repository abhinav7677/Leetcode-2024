class Solution {
public:
    vector<int> survivedRobotsHealths(vector<int>& positions, vector<int>& healths, string directions) {
        int n = positions.size();
        vector<int> ids;
        for(int i = 0; i< n; i++){
            ids.push_back(i);
        }

        // sort ids on the basis of position as we can't distrub postion array 
        // comparator to sort 
        auto compare = [&](int a, int b){
            return positions[a] <= positions[b];
        };
        sort(ids.begin(), ids.end(), compare);

        // now we will iterate acc to this sorted ids 
        stack<int> st;
        for(auto id:ids){
            if(directions[id] == 'R'){
                st.push(id);
            }else{
                while(!st.empty() && healths[id] > 0){
                    // this condition means that either all the robts in the stack are dead or if not then if the current robot's heath become zero means he is dead
                    if(healths[id] > healths[st.top()]){
                        healths[id]--;
                        // stach ke top pe jo robot tha uski health zero ho gayegi
                        healths[st.top()] = 0;
                        st.pop();
                    }else if(healths[id] < healths[st.top()]){
                        healths[id] = 0;
                        healths[st.top()]--;
                    }else{
                        // if dono ki healths same hai then 
                        healths[id] = 0;
                        healths[st.top()] = 0;
                        st.pop();
                    }
                }
            }
        }

        // now the collision is done so we need to find tha remaining healths in order or position 
        vector<int> ans;
        // iterating on the original health array and checking 
        for(int i = 0; i< n; i++){
            if(healths[i] > 0){
                ans.push_back(healths[i]);
            }
        }
        return ans;
    }
};