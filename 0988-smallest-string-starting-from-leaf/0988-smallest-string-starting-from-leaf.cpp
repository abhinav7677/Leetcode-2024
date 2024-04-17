class Solution {
public:
    void help(string& s,string& ans){
        int n=s.size(),m=ans.size();
        reverse(s.begin(),s.end());
        for(int i=0;i<min(n,m);i++){
            if(s[i]>ans[i]){
                reverse(s.begin(),s.end());
                return;
            }else if(s[i]<ans[i]){
                ans=s;
                reverse(s.begin(),s.end());
                return;
            }
        }
        if(m>n || m==0){
            ans=s;
        }
        reverse(s.begin(),s.end());

        return;
    }
    void DFS(TreeNode* root,string& s,string& ans){
        if(root==NULL) return ;
        s=s+char('a'+root->val);
        if(root->left==NULL && root->right==NULL){
            help(s,ans);
        }else{
            DFS(root->left,s,ans);
            DFS(root->right,s,ans);
        }
        s.pop_back();
        return;
    }
    string smallestFromLeaf(TreeNode* root) {
        string s="",ans="";
        DFS(root,s,ans);
        return ans;
    }
};