class Solution {
    int res =0;
    public int distributeCoins(TreeNode root) {
        move(root);
        return res;
    }


    public int  move(TreeNode root){
        if(root ==null) return 0;
// Required will be positive if extra coins or else negative for deficency.
        int required = move(root.left) + move(root.right) +root.val -1;
        res += Math.abs(required);
        return required;
    }
}