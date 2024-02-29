class Solution {
public:
    bool compare(vector<int>& arr){
        for(int i=0;i<arr.size();i++){
            if(arr[i]%2==0){
                return false;
            }
        }
        for(int i=0;i<arr.size()-1;i++){
            if(arr[i]>=arr[i+1]){
                return false;
            }
        }
        return true;
    }
    bool compare2(vector<int>& arr){
        for(int i=0;i<arr.size();i++){
            if(arr[i]%2!=0){
                return false;
            }
        }
        for(int i=0;i<arr.size()-1;i++){
            if(arr[i]<=arr[i+1]){
                return false;
            }
        }
        return true;
    }
    unordered_map<int,vector<int>>mapi;
    void odd_even(TreeNode* root,int level){
        if(root==NULL){
            return;
        }
        mapi[level].push_back(root->val);
        odd_even(root->left,level+1);
        odd_even(root->right,level+1);
    }
    bool isEvenOddTree(TreeNode* root) {
        if(root->val%2==0){return false;}
        odd_even(root,0);
        bool ans=true;
        for(auto it = mapi.begin(); it != mapi.end(); ++it){
            if(it->first%2==0){
                ans=compare(it->second);
                if(ans==false){return ans;}
            }
            else{
                ans=compare2(it->second);
                if(ans==false){return ans;}
            }
        }
        return ans;
    }
};