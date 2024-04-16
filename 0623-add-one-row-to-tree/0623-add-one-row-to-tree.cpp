class Solution {
public:
    TreeNode* solve(TreeNode* root, int val, int depth){
        if(depth == 2){
            TreeNode* newRootLeft = new TreeNode(val);
            TreeNode* newRootRight= new TreeNode(val);

            TreeNode* tempLeft = root->left;
            TreeNode* tempRight = root->right;

            newRootLeft->left = tempLeft;
            root->left = newRootLeft;

            newRootRight->right = tempRight;
            root->right = newRootRight;

            return root;
        }


        if(root->left)
            root->left = solve(root->left, val, depth-1);

        if(root->right)
            root->right = solve(root->right, val, depth-1);

        return root;
        
    }
    TreeNode* addOneRow(TreeNode* root, int val, int depth) {
        TreeNode* newRoot = new TreeNode(val);

        if(depth == 1){
            newRoot->left = root;
            return newRoot;
        }

        return solve(root, val, depth);
    }
};
