class Solution {
public:
    void Tree(TreeNode*root,int &sum){
        if(root==NULL)
        return;

        Tree(root->right,sum);
        sum+=root->val;
        root->val=sum;
        Tree(root->left,sum);
    }
    TreeNode* bstToGst(TreeNode* root) {
        int sum=0;
        Tree(root,sum);
        return root;
    }
};