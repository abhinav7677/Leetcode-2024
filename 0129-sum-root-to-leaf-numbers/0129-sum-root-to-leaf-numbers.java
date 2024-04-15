class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }
    
    private int dfs(TreeNode node, int pathSum) {
        if (node == null)
            return 0;
        
        pathSum = pathSum * 10 + node.val;
        
        if (node.left == null && node.right == null)
            return pathSum;
        
        int lt = dfs(node.left, pathSum);
        int rt =  dfs(node.right, pathSum);
        return lt + rt;
    }
}